;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns ^{:skip-wiki true}
  clojure.alpha.spec.impl
  (:require
    [clojure.alpha.spec :as s]
    [clojure.alpha.spec.protocols :as protocols
     :refer [Spec conform* unform* explain* gen* with-gen* describe*
             Schema keyspecs*
             Select]]
    [clojure.alpha.spec.gen :as gen]
    [clojure.set :as set]
    [clojure.walk :as walk]))

(set! *warn-on-reflection* true)

(defn- resolve-form
  [form]
  (if (keyword? form)
    form
    (-> form s/resolve-spec s/form)))

(defn- resolve-forms
  [forms]
  (map resolve-form forms))

(defn- maybe-spec
  "spec-or-k must be a spec, regex or resolvable kw/sym, else returns nil."
  [spec-or-k]
  (let [s (or (and (ident? spec-or-k) (#'s/reg-resolve spec-or-k))
                (s/spec? spec-or-k)
                (s/regex? spec-or-k)
                nil)]
    (if (s/regex? s)
      (#'s/with-name s (#'s/spec-name s))
      s)))

(defn- the-spec
  "spec-or-k must be a spec, regex or kw/sym, else returns nil. Throws if unresolvable kw/sym"
  [spec-or-k]
  (or (maybe-spec spec-or-k)
      (when (ident? spec-or-k)
        (throw (Exception. (str "Unable to resolve spec: " spec-or-k))))))

(defn- fn-impl
  [form gfn]
  (let [pred (s/resolve-fn form)]
    (reify
      Spec
      (conform* [_ x settings-key settings]
        (if (pred x) x ::s/invalid))
      (unform* [_ x] x)
      (explain* [_ path via in x settings-key settings]
        (when-not (pred x)
          [{:path path :pred (#'s/unfn form) :val x :via via :in in}]))
      (gen* [_ _ _ _] (if gfn
                        (gfn)
                        (gen/gen-for-pred pred)))
      (with-gen* [_ gfn] (fn-impl form gfn))
      (describe* [_] (#'s/unfn form)))))

(defmethod s/expand-spec 'fn*
  [[_ & fn-tail]]
  {:clojure.spec/op 'fn*
   :fn-tail (vec fn-tail)})

(defmethod s/create-spec 'fn*
  [{:keys [fn-tail]}]
  (fn-impl `(fn* ~@fn-tail) nil))

(defmethod s/expand-spec `fn
  [[_ & fn-tail]]
  {:clojure.spec/op `fn
   :fn-tail (vec fn-tail)})

(defmethod s/create-spec `fn
  [{:keys [fn-tail]}]
  (fn-impl `(fn ~@fn-tail) nil))

(defmethod s/expand-spec 'fn
  [[_ & fn-tail]]
  {:clojure.spec/op 'fn
   :fn-tail (vec fn-tail)})

(defmethod s/create-spec 'fn
  [{:keys [fn-tail]}]
  (fn-impl `(fn ~@fn-tail) nil))

(defmethod s/expand-spec `s/with-gen
  [[_ spec gen-fn]]
  {:clojure.spec/op `s/with-gen
   :spec spec
   :gen-fn gen-fn})

(defmethod s/create-spec `s/with-gen
  [{:keys [spec gen-fn]}]
  (let [spec (s/resolve-spec spec)
        g (s/resolve-fn gen-fn)]
    (if (s/regex? spec)
      (assoc spec ::gfn g)
      (protocols/with-gen* spec g))))

(defn- conformer-impl
  [f-form unf-form gfn]
  (let [f (s/resolve-fn f-form)
        unf (when unf-form (s/resolve-fn unf-form))]
    (reify
      protocols/Spec
      (conform* [_ x settings-key settings] (f x))
      (unform* [_ x] (if unf
                       (unf x)
                       (throw (IllegalStateException. "no unform fn for conformer"))))
      (explain* [_ path via in x settings-key settings]
        (when (s/invalid? (f x))
          [{:path path :pred `(s/conformer ~f-form ~@(if unf-form (vector unf-form) nil)) :val x :via via :in in}]))
      (gen* [_ _ _ _] (if gfn (gfn) (gen/gen-for-pred f)))
      (with-gen* [_ gfn] (conformer-impl f-form unf-form gfn))
      (describe* [_] `(s/conformer ~f-form ~@(if unf-form (vector unf-form) nil))))))

(defmethod s/expand-spec `s/conformer
  [[_ f & [unf]]]
  (cond->
    {:clojure.spec/op `s/conformer
     :f f}
    unf (assoc :unf unf)))

(defmethod s/create-spec `s/conformer
  [{:keys [f unf]}]
  (conformer-impl f unf nil))

(declare cat-impl alt-impl rep-impl rep+impl maybe-impl amp-impl)

(defmethod s/expand-spec `s/*
  [[_ pred-form]]
  {:clojure.spec/op `s/*
   :spec pred-form})

(defmethod s/create-spec `s/*
  [{:keys [spec]}]
  (rep-impl spec (s/resolve-spec spec)))

(defmethod s/expand-spec `s/+
  [[_ pred-form]]
  {:clojure.spec/op `s/+
   :spec pred-form})

(defmethod s/create-spec `s/+
  [{:keys [spec]}]
  (rep+impl spec (s/resolve-spec spec)))

(defmethod s/expand-spec `s/?
  [[_ pred-form]]
  {:clojure.spec/op `s/?
   :spec pred-form})

(defmethod s/create-spec `s/?
  [{:keys [spec]}]
  (maybe-impl (s/resolve-spec spec) spec))

(defmethod s/expand-spec `s/alt
  [[_ & key-pred-forms]]
  (let [pairs (partition 2 key-pred-forms)
        keys (mapv first pairs)
        pred-forms (mapv second pairs)]
    {:clojure.spec/op `s/alt
     :keys keys
     :specs pred-forms}))

(defmethod s/create-spec `s/alt
  [{:keys [keys specs]}]
  (assert (and (= (count keys) (count specs))
            (every? keyword? keys))
    "alt expects k1 p1 k2 p2..., where ks are keywords")
  (alt-impl keys (mapv s/resolve-spec specs) specs))

(defmethod s/expand-spec `s/cat
  [[_ & key-pred-forms]]
  (let [pairs (partition 2 key-pred-forms)
        keys (mapv first pairs)
        pred-forms (mapv second pairs)]
    {:clojure.spec/op `s/cat
     :keys keys
     :specs pred-forms}))

(defmethod s/create-spec `s/cat
  [{:keys [keys specs]}]
  (assert (and (= (count keys) (count specs)) (every? keyword? keys)) "cat expects k1 p1 k2 p2..., where ks are keywords")
  (cat-impl keys (mapv s/resolve-spec specs) specs))

(defmethod s/expand-spec 'clojure.alpha.spec/&
  [[_ re & preds]]
  {:clojure.spec/op 'clojure.alpha.spec/&
   :spec re
   :preds (vec preds)})

(defmethod s/create-spec 'clojure.alpha.spec/&
  [{:keys [spec preds]}]
  (amp-impl (s/resolve-spec spec) spec (mapv s/resolve-spec preds) (mapv #'s/unfn preds)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; impl ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn- recur-limit? [rmap id path k]
  (and (> (get rmap id) (::s/recursion-limit rmap))
         (contains? (set path) k)))

(defn- inck [m k]
  (assoc m k (inc (or (get m k) 0))))

(defn- dt
  ([pred x form] (dt pred x form nil))
  ([pred x form cpred?]
   (if pred
     (if-let [spec (the-spec pred)]
       (s/conform spec x)
       (if (ifn? pred)
         (if cpred?
           (pred x)
           (if (pred x) x ::s/invalid))
         (throw (Exception. (str (pr-str form) " is not a fn, expected predicate fn")))))
     x)))

(defn- pvalid?
  "internal helper function that returns true when x is valid for spec."
  ([pred x]
   (not (s/invalid? (dt pred x ::s/unknown))))
  ([pred x form]
   (not (s/invalid? (dt pred x form)))))

(defn- explain-1 [form pred path via in v settings-key settings]
  ;;(prn {:form form :pred pred :path path :in in :v v})
  (let [pred (maybe-spec pred)]
    (if (s/spec? pred)
      (explain* pred path (if-let [name (#'s/spec-name pred)] (conj via name) via) in v settings-key settings)
      [{:path path :pred form :val v :via via :in in}])))

(defn- explain-pred-list
  [forms preds path via in x settings-key settings]
  (loop [ret x
         [form & forms] forms
         [pred & preds] preds]
    (when pred
      (let [nret (dt pred ret form)]
        (if (s/invalid? nret)
          (explain-1 form pred path via in ret settings-key settings)
          (recur nret forms preds))))))

(declare or-k-gen and-k-gen)

(defn- k-gen
  "returns a generator for form f, which can be a keyword or a list
  starting with 'or or 'and."
  [f]
  (cond
    (keyword? f) (gen/return f)
    (= `or (first f)) (or-k-gen 1 (rest f))
    (= `and (first f)) (and-k-gen (rest f))))

(defn- or-k-gen
  "returns a tuple generator made up of generators for a random subset
  of min-count (default 0) to all elements in s."
  ([s] (or-k-gen 0 s))
  ([min-count s]
   (gen/bind (gen/tuple
               (gen/choose min-count (count s))
               (gen/shuffle (map k-gen s)))
             (fn [[n gens]]
               (apply gen/tuple (take n gens))))))

(defn- and-k-gen
  "returns a tuple generator made up of generators for every element
  in s."
  [s]
  (apply gen/tuple (map k-gen s)))

(defn- map-spec-impl
  "Do not call this directly, use 'keys'"
  [{:keys [req-un opt-un keys-pred pred-exprs opt-keys req-specs req req-keys opt-specs pred-forms opt gfn]
    :as argm}]
  (let [keys->specnames (zipmap (concat req-keys opt-keys) (concat req-specs opt-specs))
        id (java.util.UUID/randomUUID)]
    (reify
      Spec
      (conform* [_ m settings-key settings]
        (if (keys-pred m)
          (let [reg (s/registry)]
            (loop [ret m, [[k v] & ks :as keys] m]
              (if keys
                (let [sname (keys->specnames k)]
                  (if-let [s (#'s/reg-resolve sname)]
                    (let [cv (conform* s v k settings)]
                      (if (s/invalid? cv)
                        ::s/invalid
                        (recur (if (identical? cv v) ret (assoc ret k cv))
                               ks)))
                    (recur ret ks)))
                ret)))
          ::s/invalid))
      (unform* [_ m]
        (let [reg (s/registry)]
          (loop [ret m, [k & ks :as keys] (keys m)]
            (if keys
              (if (contains? reg (keys->specnames k))
                (let [cv (get m k)
                      v (s/unform (keys->specnames k) cv)]
                  (recur (if (identical? cv v) ret (assoc ret k v))
                         ks))
                (recur ret ks))
              ret))))
      (explain* [_ path via in x settings-key settings]
        (if-not (map? x)
          [{:path path :pred `map? :val x :via via :in in}]
          (let [reg (s/registry)]
            (apply concat
                   (when-let [probs (->> (map (fn [pred form] (when-not (pred x) form))
                                              pred-exprs pred-forms)
                                         (keep identity)
                                         seq)]
                     (map
                       #(identity {:path path :pred % :val x :via via :in in})
                       probs))
                   (map (fn [[k v]]
                          (when-not (or (not (contains? reg (keys->specnames k)))
                                          (pvalid? (keys->specnames k) v k))
                            (explain-1 (keys->specnames k) (keys->specnames k) (conj path k) via (conj in k) v k settings)))
                        (seq x))))))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (let [rmap (inck rmap id)
                rgen (fn [k s] [k (#'s/gensub s overrides (conj path k) rmap k)])
                ogen (fn [k s]
                       (when-not (recur-limit? rmap id path k)
                         [k (gen/delay (#'s/gensub s overrides (conj path k) rmap k))]))
                reqs (map rgen req-keys req-specs)
                opts (remove nil? (map ogen opt-keys opt-specs))]
            (when (every? identity (concat (map second reqs) (map second opts)))
              (gen/bind
                (gen/tuple
                  (and-k-gen req)
                  (or-k-gen opt)
                  (and-k-gen req-un)
                  (or-k-gen opt-un))
                (fn [[req-ks opt-ks req-un-ks opt-un-ks]]
                  (let [qks (flatten (concat req-ks opt-ks))
                        unqks (map (comp keyword name) (flatten (concat req-un-ks opt-un-ks)))]
                    (->> (into reqs opts)
                         (filter #((set (concat qks unqks)) (first %)))
                         (apply concat)
                         (apply gen/hash-map)))))))))
      (with-gen* [_ gfn] (map-spec-impl (assoc argm :gfn gfn)))
      (describe* [_] (cons `s/keys
                           (cond-> []
                                   req (conj :req req)
                                   opt (conj :opt opt)
                                   req-un (conj :req-un req-un)
                                   opt-un (conj :opt-un opt-un)))))))

(defmethod s/expand-spec `s/keys
  [[_ & opts]]
  (conj {:clojure.spec/op `s/keys} (apply hash-map opts)))

(defmethod s/create-spec `s/keys
  [{:keys [req req-un opt opt-un gen]}]
  (let [unk #(-> % name keyword)
        req-keys (filterv keyword? (flatten req))
        req-un-specs (filterv keyword? (flatten req-un))
        _ (assert (every? #(and (keyword? %) (namespace %)) (concat req-keys req-un-specs opt opt-un))
                    "all keys must be namespace-qualified keywords")
        req-specs (into req-keys req-un-specs)
        req-keys (into req-keys (map unk req-un-specs))
        opt-keys (into (vec opt) (map unk opt-un))
        opt-specs (into (vec opt) opt-un)
        gx (gensym)
        parse-req (fn [rk f]
                    (map (fn [x]
                           (if (keyword? x)
                             `(contains? ~gx ~(f x))
                             (walk/postwalk
                               (fn [y] (if (keyword? y) `(contains? ~gx ~(f y)) y))
                               x)))
                         rk))
        pred-exprs [`(map? ~gx)]
        pred-exprs (into pred-exprs (parse-req req identity))
        pred-exprs (into pred-exprs (parse-req req-un unk))
        keys-pred `(fn* [~gx] (and ~@pred-exprs))
        pred-exprs (mapv (fn [e] `(fn* [~gx] ~e)) pred-exprs)
        pred-forms (walk/postwalk #'s/res pred-exprs)]
    (map-spec-impl {:req req :opt opt :req-un req-un :opt-un opt-un
                    :req-keys req-keys :req-specs req-specs
                    :opt-keys opt-keys :opt-specs opt-specs
                    :pred-forms pred-forms
                    :pred-exprs (mapv s/resolve-fn pred-exprs)
                    :keys-pred (s/resolve-fn keys-pred)
                    :gfn (s/resolve-fn gen)})))

(defn- keyspecs
  [schema]
  (keyspecs* schema))

(defn- select?
  [spec-ref]
  (if-let [sp (if (qualified-keyword? spec-ref) (#'s/reg-resolve! spec-ref) spec-ref)]
    (satisfies? Select sp)
    false))

(defn- schema-impl
  [coll gfn]
  (let [coll (if (map? coll) [coll] coll)
        ks (filter keyword? coll)
        qks (zipmap ks ks)
        unq-map (apply merge (filter map? coll))
        unq-specs (map s/resolve-spec (vals unq-map))
        uqks (zipmap (keys unq-map) unq-specs)
        key-specs (merge uqks qks)
        lookup #(or (s/get-spec %) (get key-specs %))]
    ;; schemas cannot contain nested select specs
    (assert (every? #(if-let [sp (s/get-spec %)] (not (select? sp)) true) ks))
    (assert (every? #(not (select? %)) unq-specs))
    (reify
      Spec
      (conform* [_ x settings-key settings]
        (if (or (not (map? x))
              (and
                (-> settings (get :closed) (contains? settings-key))
                (not (set/subset? (-> x keys set) (set ks)))))
          ::s/invalid
          (loop [ret x ;; either conformed map or ::s/invalid
                 [[k v] & ks :as m] x]
            (if k
              (let [conformed (if-let [sp (lookup k)] (conform* sp v k settings) v)]
                (if (s/invalid? conformed)
                  (recur ::s/invalid nil)
                  (recur (if-not (identical? v conformed) (assoc ret k conformed) ret) ks)))
              ret))))
      (unform* [_ x]
        (loop [ret x, [[k v] & ks :as m] x]
          (if-not m
            ret
            (if-let [sp (lookup k)]
              (let [uv (s/unform sp v)]
                (recur (if (identical? uv v) ret (assoc ret k uv)) ks))
              (recur ret ks)))))
      (explain* [_ path via in x settings-key settings]
        (if (not (map? x))
          [{:path path :pred `map? :val x :via via :in in}]
          (if (and (-> settings (get :closed) (contains? settings-key))
                (not (set/subset? (-> x keys set) (set ks))))
            (let [form `(fn [~'%] (set/subset? (set (keys ~'%)) ~(set ks)))]
              [{:path path :pred form :val x :via via :in in}])
            (reduce-kv
              (fn [p k v]
                (if-let [sp (lookup k)]
                  (into p (explain-1 (s/form sp) sp (conj path k) via (conj in k) v k settings))
                  p))
              [] x))))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (let [ogen (fn [k s]
                       [k (gen/delay (#'s/gensub s overrides (conj path k) rmap k))])
                opt-kset (keys key-specs)
                opt-specs (->> opt-kset (map lookup) (remove nil?))
                opts (remove nil? (map ogen opt-kset opt-specs))]
            (when (every? identity (map second opts))
              (gen/bind
                (or-k-gen opt-kset)
                (fn [opt-ks]
                  (let [qks (flatten opt-ks)]
                    (->> opts
                         (filter #((set qks) (first %)))
                         (apply concat)
                         (apply gen/hash-map)))))))))
      (with-gen* [_ gfn] (schema-impl coll gfn))
      (describe* [_] `(s/schema ~coll))

      Schema
      (keyspecs* [_] key-specs))))

(defmethod s/expand-spec `s/schema
  [[_ coll]]
  {:clojure.spec/op `s/schema
   :schema coll})

(defmethod s/create-spec `s/schema
  [{:keys [schema]}]
  (schema-impl schema nil))

(defn- union-impl
  [schemas gfn]
  (let [ks (->> schemas (map s/schema*) (map keyspecs) (apply merge))
        qk (filterv qualified-keyword? (keys ks))
        ukv (reduce-kv (fn [m k v]
                         (if (simple-keyword? k)
                           (assoc m k (if (keyword? v) v (s/form v)))
                           m))
              {} ks)
        impl (schema-impl (if (seq ukv) (conj qk ukv) qk) nil)]
    (reify
      Spec
      (conform* [_ x settings-key settings] (conform* impl x settings-key settings))
      (unform* [_ x] (unform* impl x))
      (explain* [_ path via in x settings-key settings] (explain* impl path via in x settings-key settings))
      (gen* [_ overrides path rmap] (gen* impl overrides path rmap))
      (with-gen* [_ gfn] (union-impl schemas gfn))
      (describe* [_] `(s/union ~@schemas))

      Schema
      (keyspecs* [_] (keyspecs* impl)))))

(defmethod s/expand-spec `s/union
  [[_ & schemas]]
  {:clojure.spec/op `s/union
   :schemas (vec schemas)})

(defmethod s/create-spec `s/union
  [{:keys [schemas]}]
  (union-impl schemas nil))

(defn- select-impl
  [schema-form selection gfn]
  (let [id (java.util.UUID/randomUUID)
        schema (s/schema* schema-form)
        key-specs (keyspecs schema)
        req-kset (if (->> selection (filter symbol?) (filter #(= (name %) "*")) seq)
                   (set (keys key-specs))
                   (->> selection (filter keyword?) set))
        sub-selects (->> selection (filter map?) (apply merge))
        lookup #(if (qualified-keyword? %)
                  (let [schema-obj (s/get-spec %)]
                    (if (s/schema? schema-obj)
                      (let [sub-schema (vec (some-> schema-obj keyspecs keys))
                            sub-selection (get sub-selects % [])]
                        (s/resolve-spec `(s/select ~sub-schema ~sub-selection)))
                      schema-obj))
                  (get key-specs %))
        opt-kset (set/difference (set/union (-> key-specs keys set)
                                            (-> sub-selects keys set))
                                 req-kset)]
    (reify
      Select
      Spec
      (conform* [_ x settings-key settings]
        (if (or (not (map? x))
                (not (set/subset? req-kset (-> x keys set))))
          ::s/invalid
          (loop [ret x ;; either conformed map or ::s/invalid
                 [[k v] & ks :as m] x]
            (if k
              (let [conformed (if-let [sp (lookup k)]
                                (conform* sp v k settings)
                                v)]
                (if (s/invalid? conformed)
                  (recur ::s/invalid nil)
                  (if-let [sub-spec (lookup k)]
                    (if (not (s/valid? sub-spec (get x k)))
                      (recur ::s/invalid nil)
                      (recur (if-not (identical? v conformed) (assoc ret k conformed) ret) ks))
                    (recur (if-not (identical? v conformed) (assoc ret k conformed) ret) ks))))
              ret))))
      (unform* [_ x]
        (loop [ret x, [[k v] & ks :as m] x]
          (if-not m
            ret
            (if-let [sp (lookup k)]
              (let [uv (s/unform sp v)]
                (recur (if (identical? uv v) ret (assoc ret k uv)) ks))
              (recur ret ks)))))
      (explain* [_ path via in x settings-key settings]
        (if (not (map? x))
          [{:path path :pred `map? :val x :via via :in in}]
          (-> (concat
                ;; required key missing
                (->> req-kset
                     (keep (fn [k]
                             (when-not (contains? x k)
                               {:path path :pred `(fn [~'m] (contains? ~'m ~k)) :val x :via via :in in}))))
                ;; registered key has conforming v
                (->> x
                     (keep
                       (fn [[k v]]
                         (when-let [sp (lookup k)]
                           (explain-1 (s/form sp) sp (conj path k) via (conj in k) v k settings))))
                     (mapcat identity))
                ;; nested select matches
                (->> sub-selects
                     (keep
                       (fn [[k _]]
                         (when (contains? x k)
                           (when-let [sp (lookup k)]
                             (explain-1 (s/form sp) sp (conj path k) via (conj in k) (get x k) k settings)))))
                     (mapcat identity)))
              distinct
              vec)))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (let [rmap (inck rmap id)
                rgen (fn [k s] [k (#'s/gensub s overrides (conj path k) rmap k)])
                ogen (fn [k s]
                       (when-not (recur-limit? rmap id path k)
                         [k (gen/delay (#'s/gensub s overrides (conj path k) rmap k))]))
                req-specs (->> req-kset (map lookup) (remove nil?))
                reqs (map rgen req-kset req-specs)
                opt-specs (->> opt-kset (map lookup) (remove nil?))
                opts (remove nil? (map ogen opt-kset opt-specs))]
            (when (every? identity (concat (map second reqs) (map second opts)))
              (gen/bind
                (gen/tuple (and-k-gen req-kset) (or-k-gen opt-kset))
                (fn [[req-ks opt-ks]]
                  (let [qks (flatten (concat req-ks opt-ks))]
                    (->> (into reqs opts)
                         (filter #((set qks) (first %)))
                         (apply concat)
                         (apply gen/hash-map)))))))))
      (with-gen* [_ gfn] (select-impl schema-form selection gfn))
      (describe* [_] `(s/select ~schema-form ~selection)))))

(defmethod s/expand-spec `s/select
  [[_ schema selection]]
  {:clojure.spec/op `s/select
   :schema schema
   :selection selection})

(defmethod s/create-spec `s/select
  [{:keys [schema selection] :as x}]
  (assert (vector? selection))
  (select-impl schema selection nil))

(defn- nest-impl
  [re-form gfn]
  (let [spec (delay (s/resolve-spec re-form))]
    (reify
      Spec
      (conform* [_ x settings-key settings] (conform* @spec x settings-key settings))
      (unform* [_ x] (unform* @spec x))
      (explain* [_ path via in x settings-key settings] (explain* @spec path via in x settings-key settings))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (gen* @spec overrides path rmap)))
      (with-gen* [_ gfn] (nest-impl re-form gfn))
      (describe* [_] `(s/nest ~(describe* ~(resolve-form re-form)))))))

(defmethod s/expand-spec `s/nest
  [[_ re]]
  {:clojure.spec/op `s/nest
   :spec re})

(defmethod s/create-spec `s/nest
  [{:keys [spec]}]
  (nest-impl spec nil))

(defn- multi-spec-impl
  "Do not call this directly, use 'multi-spec'"
  ([form mmvar retag] (multi-spec-impl form mmvar retag nil))
  ([form mmvar retag gfn]
   (let [id (java.util.UUID/randomUUID)
         predx #(let [^clojure.lang.MultiFn mm @mmvar]
                  (and (.getMethod mm ((.dispatchFn mm) %))
                         (mm %)))
         dval #((.dispatchFn ^clojure.lang.MultiFn @mmvar) %)
         tag (if (keyword? retag)
               #(assoc %1 retag %2)
               retag)]
     (reify
       Spec
       (conform* [_ x settings-key settings]
         (if-let [pred (predx x)]
           (dt pred x form)
           ::s/invalid))
       (unform* [_ x] (if-let [pred (predx x)]
                        (s/unform pred x)
                        (throw (IllegalStateException. (str "No method of: " form " for dispatch value: " (dval x))))))
       (explain* [_ path via in x settings-key settings]
         (let [dv (dval x)
               path (conj path dv)]
           (if-let [pred (predx x)]
             (explain-1 form pred path via in x settings-key settings)
             [{:path path :pred form :val x :reason "no method" :via via :in in}])))
       (gen* [_ overrides path rmap]
         (if gfn
           (gfn)
           (let [gen (fn [[k f]]
                       (let [p (f nil)]
                         (let [rmap (inck rmap id)]
                           (when-not (recur-limit? rmap id path k)
                             (gen/delay
                               (gen/fmap
                                 #(tag % k)
                                 (#'s/gensub p overrides (conj path k) rmap (list 'method form k))))))))
                 gs (->> (methods @mmvar)
                         (remove (fn [[k]] (s/invalid? k)))
                         (map gen)
                         (remove nil?))]
             (when (every? identity gs)
               (gen/one-of gs)))))
       (with-gen* [_ gfn] (multi-spec-impl form mmvar retag gfn))
       (describe* [_] `(s/multi-spec ~(resolve-form form) ~retag))))))

(defmethod s/expand-spec `s/multi-spec
  [[_ mm retag]]
  {:clojure.spec/op `s/multi-spec
   :mm mm
   :retag retag})

(defmethod s/create-spec `s/multi-spec
  [{:keys [mm retag]}]
  (multi-spec-impl mm (find-var mm) retag))

(defn- tuple-impl
  "Do not call this directly, use 'tuple'"
  ([forms] (tuple-impl forms nil))
  ([forms gfn]
   (let [specs (delay (mapv s/resolve-spec forms))
         cnt (count forms)]
     (reify
       Spec
       (conform* [_ x settings-key settings]
         (let [specs @specs]
           (if-not (and (vector? x)
                          (= (count x) cnt))
             ::s/invalid
             (loop [ret x, i 0]
               (if (= i cnt)
                 ret
                 (let [v (x i)
                       cv (conform* (specs i) v settings-key settings)]
                   (if (s/invalid? cv)
                     ::s/invalid
                     (recur (if (identical? cv v) ret (assoc ret i cv))
                            (inc i)))))))))
       (unform* [_ x]
         (assert (and (vector? x)
                          (= (count x) (count forms))))
         (loop [ret x, i 0]
           (if (= i (count x))
             ret
             (let [cv (x i)
                   v (s/unform (@specs i) cv)]
               (recur (if (identical? cv v) ret (assoc ret i v))
                      (inc i))))))
       (explain* [_ path via in x settings-key settings]
         (cond
           (not (vector? x))
           [{:path path :pred `vector? :val x :via via :in in}]

           (not= (count x) (count forms))
           [{:path path :pred `(= (count ~'%) ~(count forms)) :val x :via via :in in}]

           :else
           (apply concat
                  (map (fn [i form pred]
                         (let [v (x i)]
                           (when-not (pvalid? pred v)
                             (explain-1 form pred (conj path i) via (conj in i) v settings-key settings))))
                       (range (count forms)) forms @specs))))
       (gen* [_ overrides path rmap]
         (if gfn
           (gfn)
           (let [gen (fn [i p f]
                       (#'s/gensub p overrides (conj path i) rmap f))
                 gs (map gen (range (count forms)) @specs forms)]
             (when (every? identity gs)
               (apply gen/tuple gs)))))
       (with-gen* [_ gfn] (tuple-impl forms gfn))
       (describe* [_] `(s/tuple ~@(resolve-forms forms)))))))

(defmethod s/expand-spec `s/tuple
  [[_ & preds]]
  {:clojure.spec/op `s/tuple
   :specs (vec preds)})

(defmethod s/create-spec `s/tuple
  [{:keys [specs]}]
  (tuple-impl (vec specs)))

(defn- tagged-ret [tag ret]
  (clojure.lang.MapEntry. tag ret))

(defn- or-spec-impl
  "Do not call this directly, use 'or'"
  [keys forms gfn]
  (let [id (java.util.UUID/randomUUID)
        specs (delay (mapv s/resolve-spec forms))
        kps (zipmap keys @specs)
        cform (case (count forms)
                2 (fn [x settings-key settings]
                    (let [specs @specs
                          ret (conform* (specs 0) x settings-key settings)]
                      (if (s/invalid? ret)
                        (let [ret (conform* (specs 1) x settings-key settings)]
                          (if (s/invalid? ret)
                            ::s/invalid
                            (tagged-ret (keys 1) ret)))
                        (tagged-ret (keys 0) ret))))
                3 (fn [x settings-key settings]
                    (let [specs @specs
                          ret (conform* (specs 0) x settings-key settings)]
                      (if (s/invalid? ret)
                        (let [ret (conform* (specs 1) x settings-key settings)]
                          (if (s/invalid? ret)
                            (let [ret (conform* (specs 2) x settings-key settings)]
                              (if (s/invalid? ret)
                                ::s/invalid
                                (tagged-ret (keys 2) ret)))
                            (tagged-ret (keys 1) ret)))
                        (tagged-ret (keys 0) ret))))
                (fn [x settings-key settings]
                  (let [specs @specs]
                    (loop [i 0]
                      (if (< i (count specs))
                        (let [spec (specs i)]
                          (let [ret (conform* spec x settings-key settings)]
                            (if (s/invalid? ret)
                              (recur (inc i))
                              (tagged-ret (keys i) ret))))
                        ::s/invalid)))))]
    (reify
      Spec
      (conform* [_ x settings-key settings] (cform x settings-key settings))
      (unform* [_ [k x]] (s/unform (kps k) x))
      (explain* [this path via in x settings-key settings]
        (when-not (pvalid? this x)
          (apply concat
                 (map (fn [k form pred]
                        (when-not (pvalid? pred x)
                          (explain-1 form pred (conj path k) via in x settings-key settings)))
                      keys forms @specs))))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (let [gen (fn [k p f]
                      (let [rmap (inck rmap id)]
                        (when-not (recur-limit? rmap id path k)
                          (gen/delay
                            (#'s/gensub p overrides (conj path k) rmap f)))))
                gs (remove nil? (map gen keys @specs forms))]
            (when-not (empty? gs)
              (gen/one-of gs)))))
      (with-gen* [_ gfn] (or-spec-impl keys forms gfn))
      (describe* [_] `(s/or ~@(mapcat vector keys (map resolve-form forms)))))))

(defmethod s/create-spec `s/or
  [{:keys [keys specs]}]
  (assert (= (count keys) (count specs)))
  (or-spec-impl keys specs nil))

(defmethod s/expand-spec `s/or
  [[_ & key-pred-forms]]
  (let [pairs (partition 2 key-pred-forms)
        keys (mapv first pairs)
        specs (mapv second pairs)]
    {:clojure.spec/op `s/or
     :keys keys
     :specs specs}))

(defn- and-spec-impl
  "Do not call this directly, use 'and'"
  [forms gfn]
  (let [specs (delay (mapv s/resolve-spec forms))
        cform
        (case (count forms)
          2 (fn [x settings-key settings]
              (let [specs @specs
                    ret (conform* (specs 0) x settings-key settings)]
                (if (s/invalid? ret)
                  ::s/invalid
                  (conform* (specs 1) ret settings-key settings))))
          3 (fn [x settings-key settings]
              (let [specs @specs
                    ret (conform* (specs 0) x settings-key settings)]
                (if (s/invalid? ret)
                  ::s/invalid
                  (let [ret (conform* (specs 1) ret settings-key settings)]
                    (if (s/invalid? ret)
                      ::s/invalid
                      (conform* (specs 2) ret settings-key settings))))))
          (fn [x settings-key settings]
            (let [specs @specs]
              (loop [ret x i 0]
                (if (< i (count specs))
                  (let [nret (conform* (specs i) ret settings-key settings)]
                    (if (s/invalid? nret)
                      ::s/invalid
                      ;;propagate conformed values
                      (recur nret (inc i))))
                  ret)))))]
    (reify
      Spec
      (conform* [_ x settings-key settings] (cform x settings-key settings))
      (unform* [_ x] (reduce #(s/unform %2 %1) x (reverse @specs)))
      (explain* [_ path via in x settings-key settings] (explain-pred-list (map s/form @specs) @specs path via in x settings-key settings))

      (gen* [_ overrides path rmap] (if gfn (gfn) (#'s/gensub (first @specs) overrides path rmap (first forms))))
      (with-gen* [_ gfn] (and-spec-impl forms gfn))
      (describe* [_] `(s/and ~@(resolve-forms forms))))))

(defmethod s/expand-spec `s/and
  [[_ & pred-forms]]
  {:clojure.spec/op `s/and
   :specs (vec pred-forms)})

(defmethod s/create-spec `s/and
  [{:keys [specs]}]
  (and-spec-impl specs nil))

(defn- explain-pred-list-nonflowing
  [forms preds path via in x settings-key settings]
  (loop [[form & forms] forms
         [pred & preds] preds]
    (when pred
      (let [nret (dt pred x form)]
        (if (s/invalid? nret)
          (explain-1 form pred path via in x settings-key settings)
          (recur forms preds))))))

(defn- and-nonflowing
  "Do not call this directly, use 'and-'"
  [forms gfn]
  (let [specs (delay (mapv s/resolve-spec forms))]
    (reify
      Spec
      (conform* [_ x settings-key settings]
        (let [specs @specs]
          (if (seq specs)
            (let [ret (conform* (specs 0) x settings-key settings)]
              (if (s/invalid? ret)
                ::s/invalid
                (loop [i 1]
                  (if (< i (count specs))
                    (if (s/invalid? (conform* (specs i) x settings-key settings))
                      ::s/invalid
                      (recur (inc i)))
                    ret))))
            x)))
      (unform* [_ x]
        (let [specs @specs]
          (if (seq specs)
            (s/unform (first specs) x)
            x)))
      (explain* [_ path via in x settings-key settings]
        (let [specs @specs]
          (explain-pred-list-nonflowing (map s/form specs) specs path via in x settings-key settings)))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (let [specs @specs]
            (if (seq specs)
              (#'s/gensub (first specs) overrides path rmap (first forms))
              (#'s/gensub (s/resolve-spec `any?) overrides path rmap `any?)))))
      (with-gen* [_ gfn] (and-nonflowing forms gfn))
      (describe* [_] `(s/and- ~@(resolve-forms forms))))))

(defmethod s/expand-spec `s/and-
  [[_ & pred-forms]]
  {:clojure.spec/op `s/and-
   :specs (vec pred-forms)})

(defmethod s/create-spec `s/and-
  [{:keys [specs]}]
  (and-nonflowing specs nil))

(defn- merge-spec-impl
  "Do not call this directly, use 'merge'"
  [forms preds gfn]
  (reify
    Spec
    (conform* [_ x settings-key settings]
      (let [ms (map #(dt %1 x %2) preds forms)]
        (if (some s/invalid? ms)
          ::s/invalid
          (apply merge ms))))
    (unform* [_ x] (apply merge (map #(s/unform % x) (reverse preds))))
    (explain* [_ path via in x settings-key settings]
      (apply concat
             (map #(explain-1 %1 %2 path via in x settings-key settings)
                  forms preds)))
    (gen* [_ overrides path rmap]
      (if gfn
        (gfn)
        (gen/fmap
          #(apply merge %)
          (apply gen/tuple (map #(#'s/gensub %1 overrides path rmap %2)
                                preds forms)))))
    (with-gen* [_ gfn] (merge-spec-impl forms preds gfn))
    (describe* [_] `(s/merge ~@(resolve-forms forms)))))

(defmethod s/expand-spec `s/merge
  [[_ & pred-forms]]
  {:clojure.spec/op `s/merge
   :specs (vec pred-forms)})

(defmethod s/create-spec `s/merge
  [{:keys [specs]}]
  (merge-spec-impl specs (mapv s/resolve-spec specs) nil))

(defn- coll-prob [x kfn kform distinct count min-count max-count
                  path via in settings-key settings]
  (let [pred (or kfn coll?)
        kform (or kform `coll?)]
    (cond
      (not (pvalid? pred x))
      (explain-1 kform pred path via in x settings-key settings)

      (and count (not= count (bounded-count count x)))
      [{:path path :pred `(= ~count (count ~'%)) :val x :via via :in in}]

      (and (or min-count max-count)
             (not (<= (or min-count 0)
                      (bounded-count (if max-count (inc max-count) min-count) x)
                      (or max-count Integer/MAX_VALUE))))
      [{:path path :pred `(<= ~(or min-count 0) (count ~'%) ~(or max-count 'Integer/MAX_VALUE)) :val x :via via :in in}]

      (and distinct (not (empty? x)) (not (apply distinct? x)))
      [{:path path :pred 'distinct? :val x :via via :in in}])))

(def ^:private empty-coll {`vector? [], `set? #{}, `list? (), `map? {}})

(defn- every-impl
  "Do not call this directly, use 'every', 'every-kv', 'coll-of' or 'map-of'"
  ([form opts] (every-impl form opts nil))
  ([form {conform-into :into
          describe-form ::s/describe
          :keys [kind ::s/kind-form count max-count min-count distinct gen-max ::s/kfn ::s/cpred
                 conform-keys ::s/conform-all]
          :or {gen-max 20}
          :as opts}
    gfn]
   (let [gen-into (if conform-into (empty conform-into) (get empty-coll kind-form))
         spec (delay (s/resolve-spec form))
         check? #(s/valid? @spec %)
         kfn (if kfn (s/resolve-fn kfn) (fn [i v] v))
         addcv (fn [ret i v cv] (conj ret cv))
         cfns (fn [x]
                ;;returns a tuple of [init add complete] fns
                (cond
                  (and (vector? x) (or (not conform-into) (vector? conform-into)))
                  [identity
                   (fn [ret i v cv]
                     (if (identical? v cv)
                       ret
                       (assoc ret i cv)))
                   identity]

                  (and (map? x) (or (and kind (not conform-into)) (map? conform-into)))
                  [(if conform-keys empty identity)
                   (fn [ret i v cv]
                     (if (and (identical? v cv) (not conform-keys))
                       ret
                       (assoc ret (nth (if conform-keys cv v) 0) (nth cv 1))))
                   identity]

                  (or (list? conform-into) (seq? conform-into) (and (not conform-into) (or (list? x) (seq? x))))
                  [(constantly ()) addcv reverse]

                  :else [#(empty (or conform-into %)) addcv identity]))]
     (reify
       Spec
       (conform* [_ x settings-key settings]
         (let [spec @spec]
           (cond
             (not (cpred x)) ::s/invalid
             conform-all
             (let [[init add complete] (cfns x)]
               (loop [ret (init x), i 0, [v & vs :as vseq] (seq x)]
                 (if vseq
                   (let [cv (conform* spec v settings-key settings)]
                     (if (s/invalid? cv)
                       ::s/invalid
                       (recur (add ret i v cv) (inc i) vs)))
                   (complete ret))))
             :else
             (if (indexed? x)
               (let [step (max 1 (long (/ (clojure.core/count x) s/*coll-check-limit*)))]
                 (loop [i 0]
                   (if (>= i (clojure.core/count x))
                     x
                     (if (s/valid? spec (nth x i))
                       (recur (+ i step))
                       ::s/invalid))))
               (let [limit s/*coll-check-limit*]
                 (loop [i 0 [v & vs :as vseq] (seq x)]
                   (cond
                     (or (nil? vseq) (= i limit)) x
                     (s/valid? spec v) (recur (inc i) vs)
                     :else ::s/invalid)))))))
       (unform* [_ x]
         (if conform-all
           (let [spec @spec
                 [init add complete] (cfns x)]
             (loop [ret (init x), i 0, [v & vs :as vseq] (seq x)]
               (if (>= i (clojure.core/count x))
                 (complete ret)
                 (recur (add ret i v (s/unform spec v)) (inc i) vs))))
           x))
       (explain* [_ path via in x settings-key settings]
         (or (coll-prob x kind kind-form distinct count min-count max-count
                          path via in settings-key settings)
               (apply concat
                      ((if conform-all identity (partial take s/*coll-error-limit*))
                        (keep identity
                              (map (fn [i v]
                                     (let [k (kfn i v)]
                                       (when-not (check? v)
                                         (let [prob (explain-1 form @spec path via (conj in k) v settings-key settings)]
                                           prob))))
                                   (range) x))))))
       (gen* [_ overrides path rmap]
         (if gfn
           (gfn)
           (let [pgen (#'s/gensub @spec overrides path rmap form)]
             (gen/bind
               (cond
                 gen-into (gen/return gen-into)
                 kind (gen/fmap #(if (empty? %) % (empty %))
                                (#'s/gensub (s/resolve-spec kind-form) overrides path rmap form))
                 :else (gen/return []))
               (fn [init]
                 (gen/fmap
                   #(if (vector? init) % (into init %))
                   (cond
                     distinct
                     (if count
                       (gen/vector-distinct pgen {:num-elements count :max-tries 100})
                       (gen/vector-distinct pgen {:min-elements (or min-count 0)
                                                  :max-elements (or max-count (max gen-max (* 2 (or min-count 0))))
                                                  :max-tries 100}))

                     count
                     (gen/vector pgen count)

                     (or min-count max-count)
                     (gen/vector pgen (or min-count 0) (or max-count (max gen-max (* 2 (or min-count 0)))))

                     :else
                     (gen/vector pgen 0 gen-max))))))))

       (with-gen* [_ gfn] (every-impl form opts gfn))
       (describe* [_] describe-form)))))

(defmethod s/expand-spec `s/every
  [[_ pred & opts]]
  {:clojure.spec/op `s/every
   :spec pred
   :opts (apply hash-map opts)})

(defmethod s/create-spec `s/every
  [{:keys [spec opts]}]
  (let [{:keys [into kind count max-count min-count distinct gen-max gen]} opts
        gx (gensym)
        cpreds (cond-> [(list (or kind `coll?) gx)]
                       count (conj `(= ~count (bounded-count ~count ~gx)))
                       (or min-count max-count)
                       (conj `(<= (or ~min-count 0)
                                  (bounded-count (if ~max-count (inc ~max-count) ~min-count) ~gx)
                                  (or ~max-count Integer/MAX_VALUE)))

                       distinct
                       (conj `(or (empty? ~gx) (apply distinct? ~gx))))
        cpred `(fn* [~gx] (and ~@cpreds))
        eopts (-> opts
                  (dissoc ::s/gen)
                  (assoc ::s/cpred (s/resolve-fn cpred))
                  (cond->
                    kind (assoc :kind (s/resolve-fn kind) ::s/kind-form kind)))]
    (every-impl spec eopts gen)))

(defmethod s/expand-spec `s/every-kv
  [[_ kpred vpred & opts]]
  {:clojure.spec/op `s/every-kv
   :kspec kpred
   :vspec vpred
   :opts (apply hash-map opts)})

(defmethod s/create-spec `s/every-kv
  [{:keys [kspec vspec opts]}]
  (s/create-spec
    {:clojure.spec/op `s/every
     :spec `(s/tuple ~kspec ~vspec)
     :opts (merge opts {::s/kfn (fn [i# v#] (nth v# 0))
                        :into {}
                        ::s/describe `(s/every-kv ~(resolve-form kspec) ~(resolve-form vspec) ~@(mapcat identity opts))})}))

(defmethod s/expand-spec `s/coll-of
  [[_ pred & opts]]
  {:clojure.spec/op `s/coll-of
   :spec pred
   :opts (apply hash-map opts)})

(defmethod s/create-spec `s/coll-of
  [{:keys [spec opts]}]
  (s/create-spec
    {:clojure.spec/op `s/every
     :spec spec
     :opts (merge opts {::s/conform-all true
                        ::s/describe `(s/coll-of ~(resolve-form spec) ~@(mapcat identity opts))})}))

(defmethod s/expand-spec `s/map-of
  [[_ kpred vpred & opts]]
  {:clojure.spec/op `s/map-of
   :kspec kpred
   :vspec vpred
   :opts (apply hash-map opts)})

(defmethod s/create-spec `s/map-of
  [{:keys [kspec vspec opts]}]
  (s/create-spec
    {:clojure.spec/op `s/every
     :spec `(s/tuple ~kspec ~vspec)
     :opts (merge opts {::s/kfn (fn [i# v#] (nth v# 0))
                        :into {}
                        ::s/conform-all true
                        :kind `map?
                        ::s/describe `(s/map-of ~(resolve-form kspec) ~(resolve-form vspec) ~@(mapcat identity opts))})}))

;;;;;;;;;;;;;;;;;;;;;;; regex ;;;;;;;;;;;;;;;;;;;
;;See:
;; http://matt.might.net/articles/implementation-of-regular-expression-matching-in-scheme-with-derivatives/
;; http://www.ccs.neu.edu/home/turon/re-deriv.pdf

(declare re-conform re-explain re-gen op-unform op-describe)

;;ctors

(defn- as-regex-spec
  ([re-obj]
    (as-regex-spec re-obj nil))
  ([re-obj gfn]
   (with-meta
     re-obj
     {`protocols/conform* (fn [re x settings-key settings]
                            (if (or (nil? x) (sequential? x))
                              (let [ret (re-conform re (seq x))]
                                (if (and (vector? x) (map? ret))
                                  (with-meta ret {::s/into []})
                                  ret))
                              ::s/invalid))
      `protocols/unform* (fn [re x]
                           (let [ret (op-unform re x)]
                             (if (= (-> x meta ::s/into) [])
                               (vec ret)
                               ret)))
      `protocols/explain* (fn [re path via in x settings-key settings]
                            (if (or (nil? x) (sequential? x))
                              (re-explain path via in re (seq x) settings-key settings)
                              [{:path path :pred (#'s/res `#(or (nil? %) (sequential? %))) :val x :via via :in in}]))
      `protocols/gen* (fn [re overrides path rmap]
                        (if gfn
                          (gfn)
                          (re-gen re overrides path rmap (op-describe re))))
      `protocols/with-gen* (fn [re gfn]
                             (as-regex-spec re gfn))
      `protocols/describe* (fn [re]
                             (op-describe re))})))

(defn- accept [x] (as-regex-spec {::s/op ::s/accept :ret x}))

(defn- accept? [{:keys [::s/op]}]
  (= ::s/accept op))

(defn- pcat* [{[p1 & pr :as ps] :ps,  [k1 & kr :as ks] :ks, [f1 & fr :as forms] :forms, ret :ret, rep+ :rep+}]
  (when (every? identity ps)
    (if (accept? p1)
      (let [rp (:ret p1)
            ret (conj ret (if ks {k1 rp} rp))]
        (if pr
          (pcat* {:ps pr :ks kr :forms fr :ret ret})
          (accept ret)))
      (as-regex-spec {::s/op ::s/pcat, :ps ps, :ret ret, :ks ks, :forms forms :rep+ rep+}))))

(defn- pcat [& ps] (pcat* {:ps ps :ret []}))

(defn- cat-impl
  "Do not call this directly, use 'cat'"
  [ks ps forms]
  (pcat* {:ks ks, :ps ps, :forms forms, :ret {}}))

(defn- rep* [p1 p2 ret splice form]
  (when p1
    (let [r (as-regex-spec {::s/op ::s/rep, :p2 p2, :splice splice, :forms form :id (java.util.UUID/randomUUID)})]
      (if (accept? p1)
        (assoc r :p1 p2 :ret (conj ret (:ret p1)))
        (assoc r :p1 p1, :ret ret)))))

(defn- rep-impl
  "Do not call this directly, use '*'"
  [form p]
  (rep* p p [] false form))

(defn- rep+impl
  "Do not call this directly, use '+'"
  [form p]
  (pcat* {:ps [p (rep* p p [] true form)] :forms `[~form (s/* ~form)] :ret [] :rep+ form}))

(defn- amp-impl
  "Do not call this directly, use '&'"
  [re re-form preds pred-forms]
  (as-regex-spec {::s/op ::s/amp :p1 re :amp re-form :ps preds :forms pred-forms}))

(defn- filter-alt [ps ks forms f]
  (if (or ks forms)
    (let [pks (->> (map vector ps
                        (or (seq ks) (repeat nil))
                        (or (seq forms) (repeat nil)))
                   (filter #(-> % first f)))]
      [(seq (map first pks)) (when ks (seq (map second pks))) (when forms (seq (map #(nth % 2) pks)))])
    [(seq (filter f ps)) ks forms]))

(defn- alt* [ps ks forms]
  (let [[[p1 & pr :as ps] [k1 :as ks] forms] (filter-alt ps ks forms identity)]
    (when ps
      (let [ret (as-regex-spec {::s/op ::s/alt, :ps ps, :ks ks :forms forms})]
        (if (nil? pr)
          (if k1
            (if (accept? p1)
              (accept (tagged-ret k1 (:ret p1)))
              ret)
            p1)
          ret)))))

(defn- alts [& ps] (alt* ps nil nil))
(defn- alt2 [p1 p2] (if (and p1 p2) (alts p1 p2) (or p1 p2)))

(defn- alt-impl
  "Do not call this directly, use 'alt'"
  [ks ps forms] (assoc (alt* ps ks forms) :id (java.util.UUID/randomUUID)))

(defn- maybe-impl
  "Do not call this directly, use '?'"
  [p form] (assoc (alt* [p (accept ::s/nil)] nil [form ::s/nil]) :maybe form))

(defn- noret? [p1 pret]
  (or (= pret ::s/nil)
        (and (#{::s/rep ::s/pcat} (::s/op (#'s/reg-resolve! p1))) ;;hrm, shouldn't know these
               (empty? pret))
        nil))

(declare preturn)

(defn- and-preds [x preds forms]
  (loop [ret x
         [pred & preds] preds
         [form & forms] forms]
    (if pred
      (let [nret (dt pred ret form)]
        (if (s/invalid? nret)
          ::s/invalid
          ;;propagate conformed values
          (recur nret preds forms)))
      ret)))

(defn- accept-nil? [p]
  (let [{:keys [::s/op ps p1 p2 forms] :as p} (#'s/reg-resolve! p)]
    (case op
      ::s/accept true
      nil nil
      ::s/amp (and (accept-nil? p1)
                   (let [ret (-> (preturn p1) (and-preds ps (next forms)))]
                     (not (s/invalid? ret))))
      ::s/rep (or (identical? p1 p2) (accept-nil? p1))
      ::s/pcat (every? accept-nil? ps)
      ::s/alt (some accept-nil? ps))))

(declare add-ret)

(defn- preturn [p]
  (let [{[p0 & pr :as ps] :ps, [k :as ks] :ks, :keys [::s/op p1 ret forms] :as p} (#'s/reg-resolve! p)]
    (case op
      ::s/accept ret
      nil nil
      ::s/amp (let [pret (preturn p1)]
              (if (noret? p1 pret)
                ::s/nil
                (and-preds pret ps forms)))
      ::s/rep (add-ret p1 ret k)
      ::s/pcat (add-ret p0 ret k)
      ::s/alt (let [[[p0] [k0]] (filter-alt ps ks forms accept-nil?)
                  r (if (nil? p0) ::s/nil (preturn p0))]
              (if k0 (tagged-ret k0 r) r)))))

(defn- op-unform [p x]
  ;;(prn {:p p :x x})
  (let [{[p0 & pr :as ps] :ps, [k :as ks] :ks, :keys [::s/op p1 ret forms rep+ maybe] :as p} (#'s/reg-resolve! p)
        kps (zipmap ks ps)]
    (case op
      ::s/accept [ret]
      nil [(s/unform p x)]
      ::s/amp (let [px (reduce #(s/unform %2 %1) x (reverse ps))]
              (op-unform p1 px))
      ::s/rep (mapcat #(op-unform p1 %) x)
      ::s/pcat (if rep+
               (mapcat #(op-unform p0 %) x)
               (mapcat (fn [k]
                         (when (contains? x k)
                           (op-unform (kps k) (get x k))))
                       ks))
      ::s/alt (if maybe
              [(s/unform p0 x)]
              (let [[k v] x]
                (op-unform (kps k) v))))))

(defn- add-ret [p r k]
  (let [{:keys [::s/op ps splice] :as p} (#'s/reg-resolve! p)
        prop #(let [ret (preturn p)]
                (if (empty? ret) r ((if splice into conj) r (if k {k ret} ret))))]
    (case op
      nil r
      (::s/alt ::s/accept ::s/amp)
      (let [ret (preturn p)]
        ;;(prn {:ret ret})
        (if (= ret ::s/nil) r (conj r (if k {k ret} ret))))

      (::s/rep ::s/pcat) (prop))))

(defn- deriv
  [p x]
  (let [{[p0 & pr :as ps] :ps, [k0 & kr :as ks] :ks, :keys [::s/op p1 p2 ret splice forms amp] :as p} (#'s/reg-resolve! p)]
    (when p
      (case op
        ::s/accept nil
        nil (let [ret (dt p x p)]
              (when-not (s/invalid? ret) (accept ret)))
        ::s/amp (when-let [p1 (deriv p1 x)]
                (if (= ::s/accept (::s/op p1))
                  (let [ret (-> (preturn p1) (and-preds ps (next forms)))]
                    (when-not (s/invalid? ret)
                      (accept ret)))
                  (amp-impl p1 amp ps forms)))
        ::s/pcat (alt2 (pcat* {:ps (cons (deriv p0 x) pr), :ks ks, :forms forms, :ret ret})
                     (when (accept-nil? p0) (deriv (pcat* {:ps pr, :ks kr, :forms (next forms), :ret (add-ret p0 ret k0)}) x)))
        ::s/alt (alt* (map #(deriv % x) ps) ks forms)
        ::s/rep (alt2 (rep* (deriv p1 x) p2 ret splice forms)
                    (when (accept-nil? p1) (deriv (rep* p2 p2 (add-ret p1 ret nil) splice forms) x)))))))

(defn- op-describe [p]
  (let [{:keys [::s/op ps ks forms splice p1 rep+ maybe amp] :as p} (#'s/reg-resolve! p)]
    ;;(prn {:op op :ks ks :forms forms :p p})
    (when p
      (case op
        ::s/accept nil
        nil p
        ::s/amp (list* 'clojure.alpha.spec/& (resolve-form amp) (resolve-forms forms))
        ::s/pcat (if rep+
                 (list `s/+ rep+)
                 (cons `s/cat (mapcat vector (or (seq ks) (repeat :_)) (resolve-forms forms))))
        ::s/alt (if maybe
                (list `s/? maybe)
                (cons `s/alt (mapcat vector ks (resolve-forms forms))))
        ::s/rep (list (if splice `s/+ `s/*) (resolve-form forms))))))

(defn- op-explain [form p path via in input settings-key settings]
  ;;(prn {:form form :p p :path path :input input})
  (let [[x :as input] input
        {:keys [::s/op ps ks forms splice p1 p2] :as p} (#'s/reg-resolve! p)
        via (if-let [name (#'s/spec-name p)] (conj via name) via)
        insufficient (fn [path form]
                       [{:path path
                         :reason "Insufficient input"
                         :pred form
                         :val ()
                         :via via
                         :in in}])]
    (when p
      (case op
        ::s/accept nil
        nil (if (empty? input)
              (insufficient path form)
              (explain-1 form p path via in x settings-key settings))
        ::s/amp (if (empty? input)
                (if (accept-nil? p1)
                  (explain-pred-list forms ps path via in (preturn p1) settings-key settings)
                  (insufficient path (:amp p)))
                (if-let [p1 (deriv p1 x)]
                  (explain-pred-list forms ps path via in (preturn p1) settings-key settings)
                  (op-explain (:amp p) p1 path via in input settings-key settings)))
        ::s/pcat (let [pkfs (map vector
                               ps
                               (or (seq ks) (repeat nil))
                               (or (seq forms) (repeat nil)))
                     [pred k form] (if (= 1 (count pkfs))
                                     (first pkfs)
                                     (first (remove (fn [[p]] (accept-nil? p)) pkfs)))
                     path (if k (conj path k) path)
                     form (or form (op-describe pred))]
                 (if (and (empty? input) (not pred))
                   (insufficient path form)
                   (op-explain form pred path via in input settings-key settings)))
        ::s/alt (if (empty? input)
                (insufficient path (op-describe p))
                (apply concat
                       (map (fn [k form pred]
                              (op-explain (or form (op-describe pred))
                                          pred
                                          (if k (conj path k) path)
                                          via
                                          in
                                          input
                                          settings-key
                                          settings))
                            (or (seq ks) (repeat nil))
                            (or (seq forms) (repeat nil))
                            ps)))
        ::s/rep (op-explain (if (identical? p1 p2)
                            forms
                            (op-describe p1))
                          p1 path via in input
                          settings-key settings)))))

(defn- re-gen [p overrides path rmap f]
  ;;(prn {:op op :ks ks :forms forms})
  (let [origp p
        {:keys [::s/op ps ks p1 p2 forms splice ret id ::s/gfn] :as p} (#'s/reg-resolve! p)
        rmap (if id (inck rmap id) rmap)
        ggens (fn [ps ks forms]
                (let [gen (fn [p k f]
                            ;;(prn {:k k :path path :rmap rmap :op op :id id})
                            (when-not (and rmap id k (recur-limit? rmap id path k))
                              (if id
                                (gen/delay (re-gen p overrides (if k (conj path k) path) rmap (or f p)))
                                (re-gen p overrides (if k (conj path k) path) rmap (or f p)))))]
                  (map gen ps (or (seq ks) (repeat nil)) (or (seq forms) (repeat nil)))))]
    (or (when-let [gfn (or (get overrides (#'s/spec-name origp))
                               (get overrides (#'s/spec-name p) )
                               (get overrides path))]
            (case op
              (:accept nil) (gen/fmap vector (gfn))
              (gfn)))
          (when gfn
            (gfn))
          (when p
            (case op
              ::s/accept (if (= ret ::s/nil)
                         (gen/return [])
                         (gen/return [ret]))
              nil (when-let [g (#'s/gensub p overrides path rmap f)]
                    (gen/fmap vector g))
              ::s/amp (re-gen p1 overrides path rmap (op-describe p1))
              ::s/pcat (let [gens (ggens ps ks forms)]
                       (when (every? identity gens)
                         (apply gen/cat gens)))
              ::s/alt (let [gens (remove nil? (ggens ps ks forms))]
                      (when-not (empty? gens)
                        (gen/one-of gens)))
              ::s/rep (if (recur-limit? rmap id [id] id)
                      (gen/return [])
                      (when-let [g (re-gen p2 overrides path rmap forms)]
                        (gen/fmap #(apply concat %)
                                  (gen/vector g)))))))))

(defn- re-conform [p [x & xs :as data]]
  ;;(prn {:p p :x x :xs xs})
  (if (empty? data)
    (if (accept-nil? p)
      (let [ret (preturn p)]
        (if (= ret ::s/nil)
          nil
          ret))
      ::s/invalid)
    (if-let [dp (deriv p x)]
      (recur dp xs)
      ::s/invalid)))

(defn- re-explain [path via in re input settings-key settings]
  (loop [p re [x & xs :as data] input i 0]
    ;;(prn {:p p :x x :xs xs :re re}) (prn)
    (if (empty? data)
      (if (accept-nil? p)
        nil ;;success
        (op-explain (op-describe p) p path via in nil settings-key settings))
      (if-let [dp (deriv p x)]
        (recur dp xs (inc i))
        (if (accept? p)
          (if (= (::s/op p) ::s/pcat)
            (op-explain (op-describe p) p path via (conj in i) (seq data) settings-key settings)
            [{:path path
              :reason "Extra input"
              :pred (op-describe re)
              :val data
              :via via
              :in (conj in i)}])
          (or (op-explain (op-describe p) p path via (conj in i) (seq data) settings-key settings)
                [{:path path
                  :reason "Extra input"
                  :pred (op-describe p)
                  :val data
                  :via via
                  :in (conj in i)}]))))))

(defmethod s/expand-spec `s/keys*
  [[_ & kspecs]]
  {:clojure.spec/op `s/keys*
   :specs (vec kspecs)})

(s/def ::s/kvs->map (s/conformer #(zipmap (map ::k %) (map ::v %)) #(map (fn [[k v]] {::k k ::v v}) %)))

(defmethod s/create-spec `s/keys*
  [{kspecs :specs}]
  (s/resolve-spec
    `(s/with-gen
       (s/& (s/* (s/cat ::k keyword? ::v any?))
            ::s/kvs->map
            (s/keys ~@kspecs))
       #(gen/fmap (fn [m#] (apply concat m#)) (s/gen (s/keys ~@kspecs))))))

;;;;;;;;;;;;;;;;; HOFs ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- call-valid?
  [f specs args]
  (let [cargs (s/conform (:args specs) args)]
    (when-not (s/invalid? cargs)
      (let [ret (apply f args)
            cret (s/conform (:ret specs) ret)]
        (and (not (s/invalid? cret))
               (if (:fn specs)
                 (pvalid? (:fn specs) {:args cargs :ret cret})
                 true))))))

(defn- validate-fn
  "returns f if valid, else smallest"
  [f specs iters]
  (let [g (s/gen (:args specs))
        prop (gen/for-all* [g] #(call-valid? f specs %))]
    (let [ret (gen/quick-check iters prop)]
      (if-let [[smallest] (-> ret :shrunk :smallest)]
        smallest
        f))))

(defn- fspec-impl
  "Do not call this directly, use 'fspec'"
  [argspec aform retspec rform fnspec fform gfn]
  (let [specs {:args argspec :ret retspec :fn fnspec}]
    (reify
      clojure.lang.ILookup
      (valAt [this k] (get specs k))
      (valAt [_ k not-found] (get specs k not-found))

      Spec
      (conform* [this f settings-key settings]
        (if argspec
          (if (ifn? f)
            (if (identical? f (validate-fn f specs s/*fspec-iterations*)) f ::s/invalid)
            ::s/invalid)
          (throw (Exception. (str "Can't conform fspec without args spec: " (pr-str (s/describe this)))))))
      (unform* [_ f] f)
      (explain* [_ path via in f settings-key settings]
        (if (ifn? f)
          (let [args (validate-fn f specs 100)]
            (if (identical? f args) ;;hrm, we might not be able to reproduce
              nil
              (let [ret (try (apply f args) (catch Throwable t t))]
                (if (instance? Throwable ret)
                  ;;TODO add exception data
                  [{:path path :pred '(apply fn) :val args :reason (.getMessage ^Throwable ret) :via via :in in}]

                  (let [cret (dt retspec ret rform)]
                    (if (s/invalid? cret)
                      (explain-1 rform retspec (conj path :ret) via in ret settings-key settings)
                      (when fnspec
                        (let [cargs (conform* argspec args nil settings)]
                          (explain-1 fform fnspec (conj path :fn) via in {:args cargs :ret cret} settings-key settings)))))))))
          [{:path path :pred 'ifn? :val f :via via :in in}]))
      (gen* [_ overrides _ _] (if gfn
                                (gfn)
                                (gen/return
                                  (fn [& args]
                                    (assert (pvalid? argspec args) (with-out-str (s/explain argspec args)))
                                    (gen/generate (s/gen retspec overrides))))))
      (with-gen* [_ gfn] (fspec-impl argspec aform retspec rform fnspec fform gfn))
      (describe* [_]
        (letfn [(clause-resolve ([[clause form]] (if form [clause (resolve-form form)] [])))]
          `(s/fspec ~@(mapcat clause-resolve [[:args aform] [:ret rform] [:fn fform]])))))))

(defmethod s/expand-spec `s/fspec
  [[_ & {:keys [args ret fn gen]}]]
  {:clojure.spec/op `s/fspec
   :args args
   :ret ret
   :fn fn
   :gen gen})

(defmethod s/create-spec `s/fspec
  [{:keys [args ret fn gen] :or {ret `any?}}]
  (fspec-impl (s/resolve-spec args) args
              (s/resolve-spec ret) ret
              (s/resolve-spec fn) fn (s/resolve-fn gen)))

(defn- nonconforming-impl
  ([spec]
    (nonconforming-impl spec nil))
  ([ospec gfn]
   (let [spec (delay (s/resolve-spec ospec))]
     (reify
       Spec
       (conform* [_ x settings-key settings]
         (let [ret (conform* @spec x settings-key settings)]
           (if (s/invalid? ret)
             ::s/invalid
             x)))
       (unform* [_ x] x)
       (explain* [_ path via in x settings-key settings]
         (explain* @spec path via in x settings-key settings))
       (gen* [_ overrides path rmap] (gen* @spec overrides path rmap))
       (with-gen* [_ gfn] (nonconforming-impl (nonconforming-impl spec gfn)))
       (describe* [_] `(s/nonconforming ~(resolve-form ospec)))))))

(defmethod s/expand-spec `s/nonconforming
  [[_ spec]]
  {:clojure.spec/op `s/nonconforming
   :spec spec})

(defmethod s/create-spec `s/nonconforming
  [{:keys [spec]}]
  (nonconforming-impl spec))

(defn- nilable-impl
  "Do not call this directly, use 'nilable'"
  [form gfn]
  (let [spec (delay (s/resolve-spec form))]
    (reify
      Spec
      (conform* [_ x settings-key settings] (if (nil? x) nil (conform* @spec x settings-key settings)))
      (unform* [_ x] (if (nil? x) nil (unform* @spec x)))
      (explain* [_ path via in x settings-key settings]
        (when-not (or (pvalid? @spec x) (nil? x))
          (conj
            (explain-1 (s/form @spec) @spec (conj path ::s/pred) via in x nil settings)
            {:path (conj path ::s/nil) :pred 'nil? :val x :via via :in in})))
      (gen* [_ overrides path rmap]
        (if gfn
          (gfn)
          (gen/frequency
            [[1 (gen/delay (gen/return nil))]
             [9 (gen/delay (#'s/gensub @spec overrides (conj path ::s/pred) rmap (s/form @spec)))]])))
      (with-gen* [_ gfn] (nilable-impl form gfn))
      (describe* [_] `(s/nilable ~(resolve-form form))))))

(defmethod s/expand-spec `s/nilable
  [[_ pred]]
  {:clojure.spec/op `s/nilable
   :spec pred})

(defmethod s/create-spec `s/nilable
  [{:keys [spec]}]
  (nilable-impl spec nil))
