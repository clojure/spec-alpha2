;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns
  ^{:doc "The spec library specifies the structure of data or functions and provides
  operations to validate, conform, explain, describe, and generate data based on
  the specs.

  Rationale: https://clojure.org/about/spec
  Guide: https://clojure.org/guides/spec"}
  clojure.alpha.spec
  (:refer-clojure :exclude [+ * and assert or cat def keys merge comp])
  (:require [clojure.alpha.spec.protocols :as protocols
             :refer [conform* unform* explain* gen* with-gen* describe*]]
            [clojure.walk :as walk]
            [clojure.alpha.spec.gen :as gen])
  (:import [clojure.alpha.spec.protocols Spec Schema]))

(alias 'c 'clojure.core)
(alias 'sa 'clojure.spec.alpha)

(def ^:dynamic *recursion-limit*
  "A soft limit on how many times a branching spec (or/alt/*/opt-keys/multi-spec)
  can be recursed through during generation. After this a
  non-recursive branch will be chosen."
  4)

(def ^:dynamic *fspec-iterations*
  "The number of times an anonymous fn specified by fspec will be (generatively) tested during conform"
  21)

(def ^:dynamic *coll-check-limit*
  "The number of elements validated in a collection spec'ed with 'every'"
  101)

(def ^:dynamic *coll-error-limit*
  "The number of errors reported by explain in a collection spec'ed with 'every'"
  20)

(defonce ^:private registry-ref (atom {}))

(defn registry
  "Returns the registry map, prefer 'get-spec' to lookup a spec by name"
  []
  @registry-ref)

(defn spec?
  "returns x if x is a spec object, else logical false"
  [x]
  (when (c/or (instance? Spec x) (-> x meta (contains? `conform*)))
    x))

(defn schema?
  "Returns x if x is a schema object, else logical false"
  [x]
  (instance? Schema x))

(defn get-spec
  "Returns spec registered for keyword/symbol/var k, or nil."
  [k]
  (get (registry) (if (keyword? k) k (symbol k))))

(defn- deep-resolve [reg k]
  (loop [spec k]
    (if (ident? spec)
      (recur (get reg spec))
      spec)))

(defn- reg-resolve
  "returns the spec/regex at end of alias chain starting with k, nil if not found, k if k not ident"
  [k]
  (if (ident? k)
    (let [reg @registry-ref
          spec (get reg k)]
      (if-not (ident? spec)
        spec
        (deep-resolve reg spec)))
    k))

(defn- reg-resolve!
  "returns the spec/regex at end of alias chain starting with k, throws if not found, k if k not ident"
  [k]
  (if (ident? k)
    (c/or (reg-resolve k)
          (throw (Exception. (str "Unable to resolve spec: " k))))
    k))

(defn regex?
  "returns x if x is a (clojure.spec) regex op, else logical false"
  [x]
  (c/and (::op x) x))

(defn- with-name [spec name]
  (cond
    (ident? spec) spec
    (regex? spec) (assoc spec ::name name)

    (instance? clojure.lang.IObj spec)
    (with-meta spec (assoc (meta spec) ::name name))))

(defn- spec-name [spec]
  (cond
    (ident? spec) spec

    (regex? spec) (::name spec)

    (instance? clojure.lang.IObj spec)
    (-> (meta spec) ::name)))

(defn invalid?
  "tests the validity of a conform return value"
  [ret]
  (identical? ::invalid ret))

(defn- unfn [expr]
  (if (c/and (seq? expr)
             (symbol? (first expr))
             (= "fn*" (name (first expr))))
    (let [[[s] & form] (rest expr)]
      (conj (walk/postwalk-replace {s '%} form) '[%] 'fn))
    expr))

(defn- res [form]
  (walk/postwalk
    #(cond
       (keyword? %) %
       (symbol? %) (c/or (some-> % resolve symbol) %)
       (sequential? %) (unfn %)
       :else %)
    form))

(defmulti expand-spec
  "Create a symbolic spec map from an explicated spec form. This is an
  extension point for adding new spec ops. Generally, consumers should
  instead call `resolve-spec`. For anything other than symbolic spec maps,
  return the same object unchanged."
  (fn [qform] (when (c/or (list? qform) (seq? qform)) (first qform))))

(defmethod expand-spec :default [o] o)

(defmulti create-spec
  "Create a spec object from an explicated spec map. This is an extension
  point for adding new spec ops. Generally, consumers should instead call
  `resolve-spec`."
  (fn [smap] (when (map? smap) (:clojure.spec/op smap))))

(defmethod create-spec :default [o] o)

(defn- pred-impl
  ([sym]
   (pred-impl sym nil))
  ([sym gfn]
   (let [pred (deref (find-var sym))]
     (reify
       protocols/Spec
       (conform* [_ x settings-key settings]
         (let [ret (pred x)] (if ret x ::invalid)))
       (unform* [_ x] x)
       (explain* [_ path via in x settings-key settings]
         (when (not (pred x))
           [{:path path :pred sym :val x :via via :in in}]))
       (gen* [_ _ _ _] (if gfn (gfn) (gen/gen-for-pred pred)))
       (with-gen* [_ gfn] (pred-impl sym gfn))
       (describe* [_] sym)))))

(defn- constant-val?
  [x]
  (c/or (nil? x)
        (boolean? x)
        (number? x)
        (string? x)
        (ident? x)
        (char? x)
        (c/and (coll? x) (empty? x))
        (c/and (c/or (vector? x) (set? x) (map? x))
               (every? constant-val? x))))

(defn- set-impl
  ([set-vals]
   (set-impl set-vals nil))
  ([set-vals gfn]
   (c/assert (every? constant-val? set-vals) "set specs must contain constant values")
   (let [pred #(contains? set-vals %)]
     (reify
       protocols/Spec
       (conform* [_ x settings-key settings]
         (let [ret (pred x)] (if ret x ::invalid)))
       (unform* [_ x] x)
       (explain* [_ path via in x settings-key settings]
         (when (not (pred x))
           [{:path path :pred set-vals :val x :via via :in in}]))
       (gen* [_ _ _ _] (if gfn (gfn) (gen/gen-for-pred set-vals)))
       (with-gen* [_ gfn] (set-impl set-vals gfn))
       (describe* [_] set-vals)))))

(declare gensub)

(defn resolve-fn
  "Resolves a symbolic function to a function object (predicate)."
  [fn-form]
  (eval fn-form))

(defn resolve-spec
  "Returns a spec object given a fully-qualified spec op form, symbol, set,
  or registry identifier. If needed, use 'explicate' to qualify forms."
  [qform]
  (cond
    (keyword? qform) (reg-resolve! qform)
    (qualified-symbol? qform) (pred-impl (res qform))
    (c/or (list? qform) (seq? qform)) (-> qform expand-spec create-spec)
    (map? qform) (create-spec qform)
    (set? qform) (set-impl qform)
    (nil? qform) nil
    (simple-symbol? qform) (throw (IllegalArgumentException. (str "Symbolic spec must be fully-qualified: " qform)))
    :else (throw (IllegalArgumentException. (str "Unknown spec op of type: " (class qform))))))

(defn- specize [x]
  (if (keyword? x) (reg-resolve! x) x))

(defn schema*
  "Returns a schema object given a fully-qualified schema definition.
  If needed use 'explicate' to qualify forms."
  [sform]
  (cond
    (keyword? sform) (reg-resolve! sform)
    (vector? sform) (create-spec `{:clojure.spec/op schema, :schema ~sform})
    (map? sform) (create-spec `{:clojure.spec/op schema, :schemas [~sform]})
    (c/or (list? sform) (seq? sform)) (create-spec sform)
    (nil? sform) nil
    :else (throw (IllegalArgumentException. (str "Unknown schema op of type: " (class sform))))))

(defn conform
  "Given a spec and a value, returns :clojure.alpha.spec/invalid
	if value does not match spec, else the (possibly destructured) value."
  ([spec x]
    (conform spec x nil))
  ([spec x settings]
   (if (keyword? spec)
     (conform* (reg-resolve! spec) x spec settings)
     (conform* spec x nil settings))))

(defn unform
  "Given a spec and a value created by or compliant with a call to
  'conform' with the same spec, returns a value with all conform
  destructuring undone."
  [spec x]
  (unform* (specize spec) x))

(defn form
  "returns the spec as data"
  [spec]
  ;;TODO - incorporate gens
  (describe* (specize spec)))

(defn- abbrev [form]
  (cond
   (seq? form)
   (walk/postwalk (fn [form]
                    (cond
                     (c/and (symbol? form) (namespace form))
                     (-> form name symbol)

                     (c/and (seq? form) (= 'fn (first form)) (= '[%] (second form)))
                     (last form)
                     
                     :else form))
                  form)

   (c/and (symbol? form) (namespace form))
   (-> form name symbol)

   :else form))

(defn describe
  "returns an abbreviated description of the spec as data"
  [spec]
  (abbrev (form spec)))

(defn explain-data* [spec path via in x settings-key settings]
  (let [probs (explain* (specize spec) path via in x settings-key settings)]
    (when-not (empty? probs)
      {::sa/problems probs
       ::sa/spec spec
       ::sa/value x})))

(defn explain-data
  "Given a spec and a value x which ought to conform, returns nil if x
  conforms, else a map with at least the key ::problems whose value is
  a collection of problem-maps, where problem-map has at least :path :pred and :val
  keys describing the predicate and the value that failed at that
  path."
  ([spec x]
   (explain-data spec x nil))
  ([spec x settings]
   (let [settings-key (when (keyword? spec) spec)]
     (explain-data* spec [] (if-let [name (spec-name spec)] [name] []) [] x settings-key settings))))

(defn explain-printer
  "Default printer for explain-data. nil indicates a successful validation."
  [ed]
  (if ed
    (let [problems (->> (::sa/problems ed)
                     (sort-by #(- (count (:in %))))
                     (sort-by #(- (count (:path %)))))]
      ;;(prn {:ed ed})
      (doseq [{:keys [path pred val reason via in] :as prob} problems]
        (pr val)
        (print " - failed: ")
        (if reason (print reason) (pr (abbrev pred)))
        (when-not (empty? in)
          (print (str " in: " (pr-str in))))
        (when-not (empty? path)
          (print (str " at: " (pr-str path))))
        (when-not (empty? via)
          (print (str " spec: " (pr-str (last via)))))
        (doseq [[k v] prob]
          (when-not (#{:path :pred :val :reason :via :in} k)
            (print "\n\t" (pr-str k) " ")
            (pr v)))
        (newline)))
    (println "Success!")))

(def ^:dynamic *explain-out* explain-printer)

(defn explain-out
  "Prints explanation data (per 'explain-data') to *out* using the printer in *explain-out*,
   by default explain-printer."
  [ed]
  (*explain-out* ed))

(defn explain
  "Given a spec and a value that fails to conform, prints an explanation to *out*."
  ([spec x]
   (explain spec x nil))
  ([spec x settings]
   (explain-out (explain-data spec x settings))))

(defn explain-str
  "Given a spec and a value that fails to conform, returns an explanation as a string."
  ([spec x]
   (explain-str spec x nil))
  ([spec x settings]
   (with-out-str (explain spec x settings))))

(defn valid?
  "Helper function that returns true when x is valid for spec."
  ([spec x]
    (valid? spec x nil))
  ([spec x settings]
   (if (keyword? spec)
     (let [spec' (reg-resolve! spec)]
       (not (invalid? (conform* spec' x spec settings))))
     (not (invalid? (conform* spec x nil settings))))))

(defn- gensub
  [spec overrides path rmap form]
  ;;(prn {:spec spec :over overrides :path path :form form})
  (let [spec (specize spec)]
    (if-let [g (c/or (when-let [gfn (c/or (get overrides (c/or (spec-name spec) spec))
                                          (get overrides path))]
                       (gfn))
                     (gen* spec overrides path rmap))]
      (gen/such-that #(valid? spec %) g 100)
      (let [abbr (abbrev form)]
        (throw (ex-info (str "Unable to construct gen at: " path " for: " abbr)
                        {::sa/path path ::sa/form form ::sa/failure :no-gen}))))))

(defn gen
  "Given a spec, returns the generator for it, or throws if none can
  be constructed. Optionally an overrides map can be provided which
  should map spec names or paths (vectors of keywords) to no-arg
  generator-creating fns. These will be used instead of the generators at those
  names/paths. Note that parent generator (in the spec or overrides
  map) will supersede those of any subtrees. A generator for a regex
  op must always return a sequential collection (i.e. a generator for
  s/? should return either an empty sequence/vector or a
  sequence/vector with one item in it)"
  ([spec] (gen spec nil))
  ([spec overrides] (gensub spec overrides [] {::recursion-limit *recursion-limit*} spec)))

(defn- explicate-1 [a-ns form]
  (walk/postwalk
    #(cond
       (keyword? %) %
       (symbol? %) (if-let [rs (some->> % (ns-resolve a-ns))]
                     (if (var? rs) (symbol rs) %)
                     %)
       :else %)
    form))

(defn explicate
  "Return a fully-qualified form given a namespace name context and a form"
  [ns-name form]
  (let [a-ns (find-ns ns-name)]
    (if (sequential? form)
      (map (partial explicate-1 a-ns) form)
      (explicate-1 a-ns form))))

(defn- ns-qualify
  "Qualify symbol s by resolving it or using the current *ns*."
  [s]
  (if-let [ns-sym (some-> s namespace symbol)]
    (c/or (some-> (get (ns-aliases *ns*) ns-sym) str (symbol (name s)))
          s)
    (symbol (str (.name *ns*)) (str s))))

(defmacro schema
  "Given a literal vector or map schema, expand to a proper explicated spec
  form, which when evaluated yields a schema object."
  [& coll]
  `(resolve-spec '~(explicate (ns-name *ns*) `(schema ~@coll))))

(defmacro union
  "Takes schemas and unions them, returning a schema object"
  [& schemas]
  `(resolve-spec '~(explicate (ns-name *ns*) `(union ~@schemas))))

(defmacro spec
  "Given a function symbol, set of constants, or anonymous function,
  returns a spec object."
  [s]
  `(resolve-spec '~(explicate (ns-name *ns*) s)))

(defn register
  "Given a namespace-qualified keyword or resolvable symbol k, and a
  spec-name or spec object, makes an entry in the registry mapping k
  to the spec. Use nil to remove an entry in the registry for k."
  [k s]
  (c/assert (c/and (ident? k) (namespace k)) "k must be namespaced keyword or resolvable symbol")
  (if (nil? s)
    (swap! registry-ref dissoc k)
    (swap! registry-ref assoc k (with-name s k)))
  k)

(defmacro def
  "Given a namespace-qualified keyword or resolvable symbol k, and a
  spec-name or symbolic spec, makes an entry in the registry mapping k
  to the spec. Use nil to remove an entry in the registry for k."
  [k spec-form]
  (let [k (if (symbol? k) (ns-qualify k) k)
        spec-def (cond
                   (keyword? spec-form) spec-form
                   (symbol? spec-form) `(spec ~spec-form)
                   (set? spec-form) `(spec ~spec-form)
                   (nil? spec-form) nil ;; remove mapping

                   (c/or (list? spec-form) (seq? spec-form))
                   (let [explicated-form (explicate (ns-name *ns*) spec-form)
                         op (first explicated-form)]
                     (cond
                       (#{'fn 'fn* `c/fn} op) `(s/spec ~explicated-form)
                       (contains? (-> #'create-spec deref methods c/keys set) op) explicated-form
                       :else (throw (ex-info (str "Unable to def " k ", unknown spec op: " op)
                                      {:k k :form explicated-form}))))

                   :else
                   (throw (ex-info (str "Unable to def " k ", invalid spec definition: " (pr-str spec-form))
                            {:k k :form spec-form})))]
    `(register '~k ~spec-def)))

(defmacro with-gen
  "Takes a spec and a no-arg, generator-returning fn and returns a version of that spec that uses that generator"
  [spec gen-fn]
  `(resolve-spec '~(explicate (ns-name *ns*) `(with-gen ~spec ~gen-fn))))

(defmacro merge
  "Takes map-validating specs (e.g. 'keys' specs) and
  returns a spec that returns a conformed map satisfying all of the
  specs.  Unlike 'and', merge can generate maps satisfying the
  union of the predicates."
  [& pred-forms]
  `(resolve-spec '~(explicate (ns-name *ns*) `(merge ~@pred-forms))))

(defmacro every
  "takes a pred and validates collection elements against that pred.

  Note that 'every' does not do exhaustive checking, rather it samples
  *coll-check-limit* elements. Nor (as a result) does it do any
  conforming of elements. 'explain' will report at most *coll-error-limit*
  problems.  Thus 'every' should be suitable for potentially large
  collections.

  Takes several kwargs options that further constrain the collection:

  :kind - a pred that the collection type must satisfy, e.g. vector?
        (default nil) Note that if :kind is specified and :into is
        not, this pred must generate in order for every to generate.
  :count - specifies coll has exactly this count (default nil)
  :min-count, :max-count - coll has count (<= min-count count max-count) (defaults nil)
  :distinct - all the elements are distinct (default nil)

  And additional args that control gen

  :gen-max - the maximum coll size to generate (default 20)
  :into - one of [], (), {}, #{} - the default collection to generate into
      (default: empty coll as generated by :kind pred if supplied, else [])

  Optionally takes :gen generator-fn, which must be a fn of no args that
  returns a test.check generator

  See also - coll-of, every-kv"
  [pred & {:keys [::describe] :as opts}]
  (let [nopts (dissoc opts ::describe)
        d (c/or describe `(every ~pred ~@(mapcat identity opts)))]
    `(resolve-spec '~(explicate (ns-name *ns*) `(every ~pred ::describe ~d ~@(mapcat identity nopts))))))

(defmacro every-kv
  "like 'every' but takes separate key and val preds and works on associative collections.

  Same options as 'every', :into defaults to {}

  See also - map-of"
  [kpred vpred & opts]
  `(resolve-spec '~(explicate (ns-name *ns*) `(every-kv ~kpred ~vpred ~@opts))))

(defmacro coll-of
  "Returns a spec for a collection of items satisfying pred. Unlike
  'every', coll-of will exhaustively conform every value.

  Same options as 'every'. conform will produce a collection
  corresponding to :into if supplied, else will match the input collection,
  avoiding rebuilding when possible.

  See also - every, map-of"
  [pred & opts]
  `(resolve-spec '~(explicate (ns-name *ns*) `(coll-of ~pred ~@opts))))

(defmacro map-of
  "Returns a spec for a map whose keys satisfy kpred and vals satisfy
  vpred. Unlike 'every-kv', map-of will exhaustively conform every
  value.

  Same options as 'every', :kind defaults to map?, with the addition of:

  :conform-keys - conform keys as well as values (default false)

  See also - every-kv"
  [kpred vpred & opts]
  `(resolve-spec '~(explicate (ns-name *ns*) `(map-of ~kpred ~vpred ~@opts))))

(defmacro *
  "Returns a regex op that matches zero or more values matching
  pred. Produces a vector of matches iff there is at least one match"
  [pred-form]
  `(resolve-spec '~(explicate (ns-name *ns*) `(* ~pred-form))))

(defmacro +
  "Returns a regex op that matches one or more values matching
  pred. Produces a vector of matches"
  [pred-form]
  `(resolve-spec '~(explicate (ns-name *ns*) `(+ ~pred-form))))

(defmacro ?
  "Returns a regex op that matches zero or one value matching
  pred. Produces a single value (not a collection) if matched."
  [pred-form]
  `(resolve-spec '~(explicate (ns-name *ns*) `(? ~pred-form))))

(defmacro alt
  "Takes key+pred pairs, e.g.

  (s/alt :even even? :small #(< % 42))

  Returns a regex op that returns a map entry containing the key of the
  first matching pred and the corresponding value. Thus the
  'key' and 'val' functions can be used to refer generically to the
  components of the tagged return"
  [& key-pred-forms]
  `(resolve-spec '~(explicate (ns-name *ns*) `(alt ~@key-pred-forms))))

(defmacro cat
  "Takes key+pred pairs, e.g.

  (s/cat :e even? :o odd?)

  Returns a regex op that matches (all) values in sequence, returning a map
  containing the keys of each pred and the corresponding value."
  [& key-pred-forms]
  `(resolve-spec '~(explicate (ns-name *ns*) `(cat ~@key-pred-forms))))

(defmacro &
  "takes a regex op re, and predicates. Returns a regex-op that consumes
  input as per re but subjects the resulting value to the
  conjunction of the predicates, and any conforming they might perform."
  [re & preds]
  `(resolve-spec '~(explicate (ns-name *ns*) `(clojure.alpha.spec/& ~re ~@preds))))

(defmacro nest
  "takes a regex op and returns a non-regex op that describes a nested
  sequential collection."
  [re]
  `(resolve-spec '~(explicate (ns-name *ns*) `(nest ~re))))

(defmacro conformer
  "takes a predicate function with the semantics of conform i.e. it should return either a
  (possibly converted) value or :clojure.alpha.spec/invalid, and returns a
  spec that uses it as a predicate/conformer. Optionally takes a
  second fn that does unform of result of first"
  ([f] `(resolve-spec '~(explicate (ns-name *ns*) `(conformer ~f))))
  ([f unf] `(resolve-spec '~(explicate (ns-name *ns*) `(conformer ~f ~unf)))))

(defmacro fspec
  "takes :args :ret and (optional) :fn kwargs whose values are preds
  and returns a spec whose conform/explain take a fn and validates it
  using generative testing. The conformed value is always the fn itself.

  See 'fdef' for a single operation that creates an fspec and
  registers it, as well as a full description of :args, :ret and :fn

  fspecs can generate functions that validate the arguments and
  fabricate a return value compliant with the :ret spec, ignoring
  the :fn spec if present.

  Optionally takes :gen generator-fn, which must be a fn of no args
  that returns a test.check generator."
  [& opts]
  `(resolve-spec '~(explicate (ns-name *ns*) `(fspec ~@opts))))

(defn- macroexpand-check
  [v args]
  (let [fn-spec (get-spec v)]
    (when-let [arg-spec (:args fn-spec)]
      (when (invalid? (conform arg-spec args))
        (let [ed (assoc (explain-data* arg-spec []
                                       (if-let [name (spec-name arg-spec)] [name] []) [] args nil nil)
                   ::sa/args args)]
          (throw (ex-info
                   (str "Call to " (symbol v) " did not conform to spec.")
                   ed)))))))

(defmacro fdef
  "Takes a symbol naming a function, and one or more of the following:

  :args A regex spec for the function arguments as they were a list to be
    passed to apply - in this way, a single spec can handle functions with
    multiple arities
  :ret A spec for the function's return value
  :fn A spec of the relationship between args and ret - the
    value passed is {:args conformed-args :ret conformed-ret} and is
    expected to contain predicates that relate those values

  Qualifies fn-sym with resolve, or using *ns* if no resolution found.
  Registers an fspec in the global registry, where it can be retrieved
  by calling get-spec with the var or fully-qualified symbol.

  Once registered, function specs are included in doc, checked by
  instrument, tested by the runner clojure.alpha.spec.test/check, and (if
  a macro) used to explain errors during macroexpansion.

  Note that :fn specs require the presence of :args and :ret specs to
  conform values, and so :fn specs will be ignored if :args or :ret
  are missing.

  Returns the qualified fn-sym.

  For example, to register function specs for the symbol function:

  (s/fdef clojure.core/symbol
    :args (s/alt :separate (s/cat :ns string? :n string?)
                 :str string?
                 :sym symbol?)
    :ret symbol?)"
  [fn-sym & specs]
  `(clojure.alpha.spec/def ~fn-sym (clojure.alpha.spec/fspec ~@specs)))

(defmacro keys
  "Creates and returns a map validating spec. :req and :opt are both
  vectors of namespaced-qualified keywords. The validator will ensure
  the :req keys are present. The :opt keys serve as documentation and
  may be used by the generator.

  The :req key vector supports 'and' and 'or' for key groups:

  (s/keys :req [::x ::y (or ::secret (and ::user ::pwd))] :opt [::z])

  There are also -un versions of :req and :opt. These allow
  you to connect unqualified keys to specs.  In each case, fully
  qualfied keywords are passed, which name the specs, but unqualified
  keys (with the same name component) are expected and checked at
  conform-time, and generated during gen:

  (s/keys :req-un [:my.ns/x :my.ns/y])

  The above says keys :x and :y are required, and will be validated
  and generated by specs (if they exist) named :my.ns/x :my.ns/y
  respectively.

  In addition, the values of *all* namespace-qualified keys will be validated
  (and possibly destructured) by any registered specs. Note: there is
  no support for inline value specification, by design.

  Optionally takes :gen generator-fn, which must be a fn of no args that
  returns a test.check generator."
  [& ks]
  `(resolve-spec '~(explicate (ns-name *ns*) `(keys ~@ks))))

(defmacro select
  "Takes a keyset and a selection pattern and returns a spec that
  validates a map. The keyset specifies what keys may be in the map
  and the specs to use if the keys are unqualified. The selection
  pattern indicates what keys must be in the map, and any nested
  maps."
  [keyset selection]
  `(resolve-spec '~(explicate (ns-name *ns*) `(select ~keyset ~selection))))

(defmacro multi-spec
  "Takes the name of a spec/predicate-returning multimethod and a
  tag-restoring keyword or fn (retag).  Returns a spec that when
  conforming or explaining data will pass it to the multimethod to get
  an appropriate spec. You can e.g. use multi-spec to dynamically and
  extensibly associate specs with 'tagged' data (i.e. data where one
  of the fields indicates the shape of the rest of the structure).

  (defmulti mspec :tag)

  The methods should ignore their argument and return a predicate/spec:
  (defmethod mspec :int [_] (s/keys :req-un [::tag ::i]))

  retag is used during generation to retag generated values with
  matching tags. retag can either be a keyword, at which key the
  dispatch-tag will be assoc'ed, or a fn of generated value and
  dispatch-tag that should return an appropriately retagged value.

  Note that because the tags themselves comprise an open set,
  the tag key spec cannot enumerate the values, but can e.g.
  test for keyword?.

  Note also that the dispatch values of the multimethod will be
  included in the path, i.e. in reporting and gen overrides, even
  though those values are not evident in the spec.
"
  [mm retag]
  `(resolve-spec '~(explicate (ns-name *ns*) `(multi-spec ~mm ~retag))))

(defmacro tuple
  "takes one or more preds and returns a spec for a tuple, a vector
  where each element conforms to the corresponding pred. Each element
  will be referred to in paths using its ordinal."
  [& preds]
  (c/assert (not (empty? preds)))
  `(resolve-spec '~(explicate (ns-name *ns*) `(tuple ~@preds))))

(defmacro or
  "Takes key+pred pairs, e.g.

  (s/or :even even? :small #(< % 42))

  Returns a destructuring spec that returns a map entry containing the
  key of the first matching pred and the corresponding value. Thus the
  'key' and 'val' functions can be used to refer generically to the
  components of the tagged return."
  [& key-pred-forms]
  (c/assert (c/and (even? (count key-pred-forms)) (->> key-pred-forms (partition 2) (map first) (every? keyword?)))
            "spec/or expects k1 p1 k2 p2..., where ks are keywords")
  `(resolve-spec '~(explicate (ns-name *ns*) `(or ~@key-pred-forms))))

(defmacro and
  "Takes predicate/spec-forms, e.g.

  (s/and int? even? #(< % 42))

  Returns a spec that returns the conformed value. Successive
  conformed values propagate through rest of predicates."
  [& pred-forms]
  `(resolve-spec '~(explicate (ns-name *ns*) `(and ~@pred-forms))))

(defmacro and-
  "Takes predicate/spec-forms, e.g.

  (s/and- (s/cat :i int?) #(pos? (first %)))

  Returns a spec that validates all preds on and returns the conformed value of
  the first pred. Conformed values are NOT propagated through rest of predicates."
  [& pred-forms]
  `(resolve-spec '~(explicate (ns-name *ns*) `(and- ~@pred-forms))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; non-primitives ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defmacro keys*
  "takes the same arguments as spec/keys and returns a regex op that matches sequences of key/values,
  converts them into a map, and conforms that map with a corresponding
  spec/keys call:

  user=> (s/conform (s/keys :req-un [::a ::c]) {:a 1 :c 2})
  {:a 1, :c 2}
  user=> (s/conform (s/keys* :req-un [::a ::c]) [:a 1 :c 2])
  {:a 1, :c 2}

  the resulting regex op can be composed into a larger regex:

  user=> (s/conform (s/cat :i1 integer? :m (s/keys* :req-un [::a ::c]) :i2 integer?) [42 :a 1 :c 2 :d 4 99])
  {:i1 42, :m {:a 1, :c 2, :d 4}, :i2 99}"
  [& kspecs]
  `(resolve-spec '~(explicate (ns-name *ns*) `(keys* ~@kspecs))))

(defmacro nonconforming
  "takes a spec and returns a spec that has the same properties except
  'conform' returns the original (not the conformed) value."
  [spec]
  `(resolve-spec '~(explicate (ns-name *ns*) `(nonconforming ~spec))))

(defmacro nilable
  "returns a spec that accepts nil and values satisfying pred"
  [pred]
  `(resolve-spec '~(explicate (ns-name *ns*) `(nilable ~pred))))

(defn exercise
  "generates a number (default 10) of values compatible with spec and maps conform over them,
  returning a sequence of [val conformed-val] tuples. Optionally takes
  a generator overrides map as per gen"
  ([spec] (exercise spec 10))
  ([spec n] (exercise spec n nil))
  ([spec n overrides]
     (map #(vector % (conform spec %)) (gen/sample (gen spec overrides) n))))

(defn exercise-fn
  "exercises the fn named by sym (a symbol) by applying it to
  n (default 10) generated samples of its args spec. When fspec is
  supplied its arg spec is used, and sym-or-f can be a fn.  Returns a
  sequence of tuples of [args ret]. "
  ([sym] (exercise-fn sym 10))
  ([sym n] (exercise-fn sym n (get-spec sym)))
  ([sym-or-f n fspec]
     (let [f (if (symbol? sym-or-f) (resolve sym-or-f) sym-or-f)]
       (if-let [arg-spec (c/and fspec (:args fspec))]
         (for [args (gen/sample (gen arg-spec) n)]
           [args (apply f args)])
         (throw (Exception. "No :args spec found, can't generate"))))))

(defn inst-in-range?
  "Return true if inst at or after start and before end"
  [start end inst]
  (c/and (inst? inst)
         (let [t (inst-ms inst)]
           (c/and (<= (inst-ms start) t) (< t (inst-ms end))))))

(defn int-in-range?
  "Return true if start <= val, val < end and val is a fixed
  precision integer."
  [start end val]
  (c/and (int? val) (<= start val) (< val end)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; assert ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defonce
  ^{:dynamic true
    :doc "If true, compiler will enable spec asserts, which are then
subject to runtime control via check-asserts? If false, compiler
will eliminate all spec assert overhead. See 'assert'.

Initially set to boolean value of clojure.spec.compile-asserts
system property. Defaults to true."}
  *compile-asserts*
  (not= "false" (System/getProperty "clojure.spec.compile-asserts")))

(defn check-asserts?
  "Returns the value set by check-asserts."
  []
  clojure.lang.RT/checkSpecAsserts)

(defn check-asserts
  "Enable or disable spec asserts that have been compiled
with '*compile-asserts*' true.  See 'assert'.

Initially set to boolean value of clojure.spec.check-asserts
system property. Defaults to false."
  [flag]
  (set! (. clojure.lang.RT checkSpecAsserts) flag))

(defn assert*
  "Do not call this directly, use 'assert'."
  [spec x]
  (if (valid? spec x)
    x
    (let [ed (c/merge (assoc (explain-data* spec [] [] [] x nil nil)
                        ::sa/failure :assertion-failed))]
      (throw (ex-info
              (str "Spec assertion failed\n" (with-out-str (explain-out ed)))
              ed)))))

(defmacro assert
  "spec-checking assert expression. Returns x if x is valid? according
to spec, else throws an ex-info with explain-data plus ::failure of
:assertion-failed.

Can be disabled at either compile time or runtime:

If *compile-asserts* is false at compile time, compiles to x. Defaults
to value of 'clojure.spec.compile-asserts' system property, or true if
not set.

If (check-asserts?) is false at runtime, always returns x. Defaults to
value of 'clojure.spec.check-asserts' system property, or false if not
set. You can toggle check-asserts? with (check-asserts bool)."
  [spec x]
  (if *compile-asserts*
    `(if clojure.lang.RT/checkSpecAsserts
       (assert* ~spec ~x)
       ~x)
    x))

(defn ^:skip-wiki sig-map
  "Do not call directly."
  [sig vals]
  (let [locals (->> sig
                    (tree-seq coll? identity)
                    (filter #(c/and (symbol? %) (not= '& %)))
                    distinct
                    vec)]
    (zipmap locals (eval `(let [~sig ~(vec vals)] ~locals)))))

(defn ^:skip-wiki op-spec
  "Do not call directly, use `defop`"
  [sp form gfn]
  (reify
    protocols/Spec
    (conform* [_ x settings-key settings] (protocols/conform* @sp x settings-key settings))
    (unform* [_ x] (unform @sp x))
    (explain* [_ path via in x settings-key settings]
      (protocols/explain* @sp path via in x settings-key settings))
    (gen* [_ _ _ _] (if gfn (gfn) (gen @sp)))
    (with-gen* [_ gfn] (op-spec sp form gfn))
    (describe* [_] form)))

(defmacro defop
  "Defines a new spec op with op-name defined by the form. Defines a macro for op-name with docstring that
  expands to a call to resolve-spec with the explicated form. args are replaced in the form. Creates a create-spec
  method implementation for op-name that creates a spec whose body is form.

  Opts allowed:
   :gen - takes a no-arg function returning a generator to use"
  {:arglists '([op-name doc-string? opts? [params*] form])}
  [op-name & op-tail]
  (let [form (last op-tail)
        opts (butlast op-tail)
        [doc args opts] (if (string? (first opts))
                          [(first opts) (second opts) (nthrest opts 2)]
                          [nil (first opts) (rest opts)])
        _ (c/assert (even? (count opts)) "defop options should be keyword/value pairs")
        {:keys [gen]} opts
        ns-name (ns-name *ns*)
        op (symbol (name ns-name) (name op-name))]
    `(do
       (defmethod expand-spec '~op
         [[~'_ ~'& ~'sargs]]
         (let [os# '~op]
           {:clojure.spec/op os#
            :args ~'sargs}))
       (defmethod create-spec '~op
         [~'mform]
         (let [a# (:args ~'mform)
               m# (sig-map '~args a#) ;; map of arg name to arg value
               sp# (delay (resolve-spec (explicate '~ns-name (walk/postwalk (fn [x#] (get m# x# x#)) '~form))))]
           (op-spec sp# (cons '~op a#) (resolve-fn (walk/postwalk (fn [x#] (get m# x# x#)) '~gen)))))
       (defmacro ~op-name
         ~@(if doc [doc] [])       ;; docstring
         {:arglists (list '~args)} ;; metadata with arglists
         [~'& ~'sargs]
         (list `resolve-spec (list `explicate (list `quote '~ns-name) (list `quote (cons '~op ~'sargs))))))))

;; Load the spec op implementations
(load "/clojure/alpha/spec/impl")

;; Derived ops

(defop inst-in
  "Returns a spec that validates insts in the range from start
  (inclusive) to end (exclusive)."
  [start end]
  :gen #(clojure.alpha.spec.gen/fmap (fn [^long d] (java.util.Date. d))
         (clojure.alpha.spec.gen/large-integer* {:min (inst-ms start) :max (inst-ms end)}))
  (and inst? #(inst-in-range? start end %)))

(defop int-in
  "Returns a spec that validates fixed precision integers in the
  range from start (inclusive) to end (exclusive)."
  [start end]
  :gen #(clojure.alpha.spec.gen/large-integer* {:min start :max (dec end)})
  (and int? #(int-in-range? start end %)))

(defop double-in
  "Specs a 64-bit floating point number. Options:

    :infinite? - whether +/- infinity allowed (default true)
    :NaN?      - whether NaN allowed (default true)
    :min       - minimum value (inclusive, default none)
    :max       - maximum value (inclusive, default none)"
  [& {:keys [infinite? NaN? min max :as m]}]
  :gen #(clojure.alpha.spec.gen/double* m)
  (and double?
       #(if-not infinite? (not (Double/isInfinite %)))
       #(if-not NaN? (not (Double/isNaN %)))
       #(if min (<= min %) true)
       #(if max (<= % max) true)))

(defmacro defcompop
  "Defines a new composite spec with op-name and args same as spec-op.
  The new spec takes the same args as spec-op, and also ensures the preds
  are satisfied."
  {:arglists '([op-name doc-string? spec-op preds+])}
  [op-name & tail]
  (let [[doc spec-op & preds] (if (string? (first tail)) tail (cons nil tail))
        ns-name (ns-name *ns*)
        op (symbol (name ns-name) (name op-name))]
    (c/assert (pos? (count preds)) "defcompop should have at least one pred")
    `(do
       (defmethod expand-spec '~op
         [[~'_ ~'& ~'sargs]]
         (let [os# '~op]
           {:clojure.spec/op os#
            :primary '~(explicate ns-name spec-op)
            :preds '~(explicate ns-name preds)
            :args ~'sargs}))
       (defmethod create-spec '~op
         [~'mform]
         (let [primary# (:primary ~'mform)
               preds# (:preds ~'mform)
               a# (:args ~'mform)
               comp-spec# (concat (list 'clojure.alpha.spec/and- (cons '~(explicate ns-name spec-op) a#)) preds#)]
           (resolve-spec comp-spec#)))
       (defmacro ~op-name
         ~@(if doc [doc] [])
         {:arglists '~(:arglists (meta (find-var (explicate ns-name spec-op))))}
         [~'& ~'sargs]
         (list `resolve-spec (list `explicate (list `quote '~ns-name) (list `quote (cons '~op ~'sargs))))))))

(defcompop catv "Like s/cat, but constrain to only vectors" cat vector?)
(defcompop cats "Like s/cat, but constrain to only seqs" cat seq?)
