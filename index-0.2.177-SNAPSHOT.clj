{:namespaces
 ({:doc nil,
   :name "clojure.spec-alpha2",
   :wiki-url "https://clojure.github.io/spec-alpha2/index.html",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj"}
  {:doc nil,
   :name "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2/index.html#clojure.spec-alpha2.gen",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj"}
  {:doc nil,
   :name "clojure.spec-alpha2.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2/index.html#clojure.spec-alpha2.protocols",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/protocols.clj"}
  {:doc nil,
   :name "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2/index.html#clojure.spec-alpha2.test",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "&",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L536",
   :line 536,
   :var-type "macro",
   :arglists ([re & preds]),
   :doc
   "takes a regex op re, and predicates. Returns a regex-op that consumes\ninput as per re but subjects the resulting value to the\nconjunction of the predicates, and any conforming they might perform.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/&"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L496",
   :line 496,
   :var-type "macro",
   :arglists ([pred-form]),
   :doc
   "Returns a regex op that matches zero or more values matching\npred. Produces a vector of matches iff there is at least one match",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "*coll-check-limit*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L30",
   :dynamic true,
   :line 30,
   :var-type "var",
   :arglists nil,
   :doc
   "The number of elements validated in a collection spec'ed with 'every'",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/*coll-check-limit*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "*coll-error-limit*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L34",
   :dynamic true,
   :line 34,
   :var-type "var",
   :arglists nil,
   :doc
   "The number of errors reported by explain in a collection spec'ed with 'every'",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/*coll-error-limit*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "*compile-asserts*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L789",
   :dynamic true,
   :line 789,
   :var-type "var",
   :arglists nil,
   :doc
   "If true, compiler will enable spec asserts, which are then\nsubject to runtime control via check-asserts? If false, compiler\nwill eliminate all spec assert overhead. See 'assert'.\n\nInitially set to boolean value of clojure.spec.compile-asserts\nsystem property. Defaults to true.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/*compile-asserts*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "*fspec-iterations*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L26",
   :dynamic true,
   :line 26,
   :var-type "var",
   :arglists nil,
   :doc
   "The number of times an anonymous fn specified by fspec will be (generatively) tested during conform",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/*fspec-iterations*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "*recursion-limit*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L20",
   :dynamic true,
   :line 20,
   :var-type "var",
   :arglists nil,
   :doc
   "A soft limit on how many times a branching spec (or/alt/*/opt-keys/multi-spec)\ncan be recursed through during generation. After this a\nnon-recursive branch will be chosen.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/*recursion-limit*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "+",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L502",
   :line 502,
   :var-type "macro",
   :arglists ([pred-form]),
   :doc
   "Returns a regex op that matches one or more values matching\npred. Produces a vector of matches",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/+"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L508",
   :line 508,
   :var-type "macro",
   :arglists ([pred-form]),
   :doc
   "Returns a regex op that matches zero or one value matching\npred. Produces a single value (not a collection) if matched.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "alt",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L514",
   :line 514,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc
   "Takes key+pred pairs, e.g.\n\n(s/alt :even even? :small #(< % 42))\n\nReturns a regex op that returns a map entry containing the key of the\nfirst matching pred and the corresponding value. Thus the\n'key' and 'val' functions can be used to refer generically to the\ncomponents of the tagged return",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/alt"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "and",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L712",
   :line 712,
   :var-type "macro",
   :arglists ([& pred-forms]),
   :doc
   "Takes predicate/spec-forms, e.g.\n\n(s/and even? #(< % 42))\n\nReturns a spec that returns the conformed value. Successive\nconformed values propagate through rest of predicates.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/and"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "assert",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L825",
   :line 825,
   :var-type "macro",
   :arglists ([spec x]),
   :doc
   "spec-checking assert expression. Returns x if x is valid? according\nto spec, else throws an ex-info with explain-data plus ::failure of\n:assertion-failed.\n\nCan be disabled at either compile time or runtime:\n\nIf *compile-asserts* is false at compile time, compiles to x. Defaults\nto value of 'clojure.spec.compile-asserts' system property, or true if\nnot set.\n\nIf (check-asserts?) is false at runtime, always returns x. Defaults to\nvalue of 'clojure.spec.check-asserts' system property, or false if not\nset. You can toggle check-asserts? with (check-asserts bool).",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/assert"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "assert*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L814",
   :line 814,
   :var-type "function",
   :arglists ([spec x]),
   :doc "Do not call this directly, use 'assert'.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/assert*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "cat",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L526",
   :line 526,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc
   "Takes key+pred pairs, e.g.\n\n(s/cat :e even? :o odd?)\n\nReturns a regex op that matches (all) values in sequence, returning a map\ncontaining the keys of each pred and the corresponding value.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/cat"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "check-asserts",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L805",
   :line 805,
   :var-type "function",
   :arglists ([flag]),
   :doc
   "Enable or disable spec asserts that have been compiled\nwith '*compile-asserts*' true.  See 'assert'.\n\nInitially set to boolean value of clojure.spec.check-asserts\nsystem property. Defaults to false.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/check-asserts"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "check-asserts?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L800",
   :line 800,
   :var-type "function",
   :arglists ([]),
   :doc "Returns the value set by check-asserts.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/check-asserts?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "coll-of",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L471",
   :line 471,
   :var-type "macro",
   :arglists ([pred & opts]),
   :doc
   "Returns a spec for a collection of items satisfying pred. Unlike\n'every', coll-of will exhaustively conform every value.\n\nSame options as 'every'. conform will produce a collection\ncorresponding to :into if supplied, else will match the input collection,\navoiding rebuilding when possible.\n\nSee also - every, map-of",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/coll-of"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "conform",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L211",
   :line 211,
   :var-type "function",
   :arglists ([spec x]),
   :doc
   "Given a spec and a value, returns :clojure.spec-alpha2/invalid \n\tif value does not match spec, else the (possibly destructured) value.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/conform"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "conformer",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L549",
   :line 549,
   :var-type "macro",
   :arglists ([f] [f unf]),
   :doc
   "takes a predicate function with the semantics of conform i.e. it should return either a\n(possibly converted) value or :clojure.spec-alpha2/invalid, and returns a\nspec that uses it as a predicate/conformer. Optionally takes a\nsecond fn that does unform of result of first",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/conformer"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "create-spec",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L130",
   :line 130,
   :var-type "multimethod",
   :arglists nil,
   :doc
   "Create a spec object from an explicated spec form. This is an extension\npoint for adding new spec forms. Generally, consumers should instead call\n`spec*` instead.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/create-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "def",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L399",
   :line 399,
   :var-type "macro",
   :arglists ([k spec-form]),
   :doc
   "Given a namespace-qualified keyword or resolvable symbol k, and a\nspec-name or symbolic spec, makes an entry in the registry mapping k\nto the spec. Use nil to remove an entry in the registry for k.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/def"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "defop",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L868",
   :line 868,
   :var-type "macro",
   :arglists ([op-name doc-string? opts? form]),
   :doc
   "Defines a new spec op with op-name defined by the form. Defines a macro for op-name with docstring that\nexpands to a call to spec* with the explicated form. args are replaced in the form. Creates a create-spec\nmethod implementation for op-name that creates a spec whose body is form.\n\nOpts allowed:\n :gen - takes a no-arg function returning a generator to use",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/defop"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "describe",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L249",
   :line 249,
   :var-type "function",
   :arglists ([spec]),
   :doc "returns an abbreviated description of the spec as data",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/describe"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "double-in",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L918",
   :line 918,
   :var-type "macro",
   :arglists ([& {:keys [infinite? NaN? min max :as m]}]),
   :doc
   "Specs a 64-bit floating point number. Options:\n\n:infinite? - whether +/- infinity allowed (default true)\n:NaN?      - whether NaN allowed (default true)\n:min       - minimum value (inclusive, default none)\n:max       - maximum value (inclusive, default none)",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/double-in"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "every",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L429",
   :line 429,
   :var-type "macro",
   :arglists
   ([pred & {:keys [:clojure.spec-alpha2/describe], :as opts}]),
   :doc
   "takes a pred and validates collection elements against that pred.\n\nNote that 'every' does not do exhaustive checking, rather it samples\n*coll-check-limit* elements. Nor (as a result) does it do any\nconforming of elements. 'explain' will report at most *coll-error-limit*\nproblems.  Thus 'every' should be suitable for potentially large\ncollections.\n\nTakes several kwargs options that further constrain the collection:\n\n:kind - a pred that the collection type must satisfy, e.g. vector?\n      (default nil) Note that if :kind is specified and :into is\n      not, this pred must generate in order for every to generate.\n:count - specifies coll has exactly this count (default nil)\n:min-count, :max-count - coll has count (<= min-count count max-count) (defaults nil)\n:distinct - all the elements are distinct (default nil)\n\nAnd additional args that control gen\n\n:gen-max - the maximum coll size to generate (default 20)\n:into - one of [], (), {}, #{} - the default collection to generate into\n    (default: empty coll as generated by :kind pred if supplied, else [])\n\nOptionally takes :gen generator-fn, which must be a fn of no args that\nreturns a test.check generator\n\nSee also - coll-of, every-kv",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/every"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "every-kv",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L462",
   :line 462,
   :var-type "macro",
   :arglists ([kpred vpred & opts]),
   :doc
   "like 'every' but takes separate key and val preds and works on associative collections.\n\nSame options as 'every', :into defaults to {}\n\nSee also - map-of",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/every-kv"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "exercise",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L752",
   :line 752,
   :var-type "function",
   :arglists ([spec] [spec n] [spec n overrides]),
   :doc
   "generates a number (default 10) of values compatible with spec and maps conform over them,\nreturning a sequence of [val conformed-val] tuples. Optionally takes\na generator overrides map as per gen",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/exercise"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "exercise-fn",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L761",
   :line 761,
   :var-type "function",
   :arglists ([sym] [sym n] [sym-or-f n fspec]),
   :doc
   "exercises the fn named by sym (a symbol) by applying it to\nn (default 10) generated samples of its args spec. When fspec is\nsupplied its arg spec is used, and sym-or-f can be a fn.  Returns a\nsequence of tuples of [args ret]. ",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/exercise-fn"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "explain",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L303",
   :line 303,
   :var-type "function",
   :arglists ([spec x]),
   :doc
   "Given a spec and a value that fails to conform, prints an explanation to *out*.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/explain"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "explain-data",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L261",
   :line 261,
   :var-type "function",
   :arglists ([spec x]),
   :doc
   "Given a spec and a value x which ought to conform, returns nil if x\nconforms, else a map with at least the key ::problems whose value is\na collection of problem-maps, where problem-map has at least :path :pred and :val\nkeys describing the predicate and the value that failed at that\npath.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/explain-data"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "explain-out",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L297",
   :line 297,
   :var-type "function",
   :arglists ([ed]),
   :doc
   "Prints explanation data (per 'explain-data') to *out* using the printer in *explain-out*,\nby default explain-printer.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/explain-out"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "explain-printer",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L270",
   :line 270,
   :var-type "function",
   :arglists ([ed]),
   :doc
   "Default printer for explain-data. nil indicates a successful validation.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/explain-printer"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "explain-str",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L308",
   :line 308,
   :var-type "function",
   :arglists ([spec x]),
   :doc
   "Given a spec and a value that fails to conform, returns an explanation as a string.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/explain-str"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "explicate",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L355",
   :line 355,
   :var-type "function",
   :arglists ([ns-name form]),
   :doc
   "Return a fully-qualified form given a namespace name context and a form",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/explicate"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "fdef",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L586",
   :line 586,
   :var-type "macro",
   :arglists ([fn-sym & specs]),
   :doc
   "Takes a symbol naming a function, and one or more of the following:\n\n:args A regex spec for the function arguments as they were a list to be\n  passed to apply - in this way, a single spec can handle functions with\n  multiple arities\n:ret A spec for the function's return value\n:fn A spec of the relationship between args and ret - the\n  value passed is {:args conformed-args :ret conformed-ret} and is\n  expected to contain predicates that relate those values\n\nQualifies fn-sym with resolve, or using *ns* if no resolution found.\nRegisters an fspec in the global registry, where it can be retrieved\nby calling get-spec with the var or fully-qualified symbol.\n\nOnce registered, function specs are included in doc, checked by\ninstrument, tested by the runner clojure.spec-alpha2.test/check, and (if\na macro) used to explain errors during macroexpansion.\n\nNote that :fn specs require the presence of :args and :ret specs to\nconform values, and so :fn specs will be ignored if :args or :ret\nare missing.\n\nReturns the qualified fn-sym.\n\nFor example, to register function specs for the symbol function:\n\n(s/fdef clojure.core/symbol\n  :args (s/alt :separate (s/cat :ns string? :n string?)\n               :str string?\n               :sym symbol?)\n  :ret symbol?)",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/fdef"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "form",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L224",
   :line 224,
   :var-type "function",
   :arglists ([spec]),
   :doc "returns the spec as data",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/form"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "fspec",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L557",
   :line 557,
   :var-type "macro",
   :arglists ([& opts]),
   :doc
   "takes :args :ret and (optional) :fn kwargs whose values are preds\nand returns a spec whose conform/explain take a fn and validates it\nusing generative testing. The conformed value is always the fn itself.\n\nSee 'fdef' for a single operation that creates an fspec and\nregisters it, as well as a full description of :args, :ret and :fn\n\nfspecs can generate functions that validate the arguments and\nfabricate a return value compliant with the :ret spec, ignoring\nthe :fn spec if present.\n\nOptionally takes :gen generator-fn, which must be a fn of no args\nthat returns a test.check generator.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/fspec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "gen",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L332",
   :line 332,
   :var-type "function",
   :arglists ([spec] [spec overrides]),
   :doc
   "Given a spec, returns the generator for it, or throws if none can\nbe constructed. Optionally an overrides map can be provided which\nshould map spec names or paths (vectors of keywords) to no-arg\ngenerator-creating fns. These will be used instead of the generators at those\nnames/paths. Note that parent generator (in the spec or overrides\nmap) will supersede those of any subtrees. A generator for a regex\nop must always return a sequential collection (i.e. a generator for\ns/? should return either an empty sequence/vector or a\nsequence/vector with one item in it)",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/gen"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "get-spec",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L56",
   :line 56,
   :var-type "function",
   :arglists ([k]),
   :doc "Returns spec registered for keyword/symbol/var k, or nil.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/get-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "inst-in",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L903",
   :line 903,
   :var-type "macro",
   :arglists ([start end]),
   :doc
   "Returns a spec that validates insts in the range from start\n(inclusive) to end (exclusive).",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/inst-in"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "inst-in-range?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L775",
   :line 775,
   :var-type "function",
   :arglists ([start end inst]),
   :doc "Return true if inst at or after start and before end",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/inst-in-range?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "int-in",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L911",
   :line 911,
   :var-type "macro",
   :arglists ([start end]),
   :doc
   "Returns a spec that validates fixed precision integers in the\nrange from start (inclusive) to end (exclusive).",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/int-in"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "int-in-range?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L782",
   :line 782,
   :var-type "function",
   :arglists ([start end val]),
   :doc
   "Return true if start <= val, val < end and val is a fixed\nprecision integer.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/int-in-range?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "invalid?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L108",
   :line 108,
   :var-type "function",
   :arglists ([ret]),
   :doc "tests the validity of a conform return value",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/invalid?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "keys",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L621",
   :line 621,
   :var-type "macro",
   :arglists ([& ks]),
   :doc
   "Creates and returns a map validating spec. :req and :opt are both\nvectors of namespaced-qualified keywords. The validator will ensure\nthe :req keys are present. The :opt keys serve as documentation and\nmay be used by the generator.\n\nThe :req key vector supports 'and' and 'or' for key groups:\n\n(s/keys :req [::x ::y (or ::secret (and ::user ::pwd))] :opt [::z])\n\nThere are also -un versions of :req and :opt. These allow\nyou to connect unqualified keys to specs.  In each case, fully\nqualfied keywords are passed, which name the specs, but unqualified\nkeys (with the same name component) are expected and checked at\nconform-time, and generated during gen:\n\n(s/keys :req-un [:my.ns/x :my.ns/y])\n\nThe above says keys :x and :y are required, and will be validated\nand generated by specs (if they exist) named :my.ns/x :my.ns/y\nrespectively.\n\nIn addition, the values of *all* namespace-qualified keys will be validated\n(and possibly destructured) by any registered specs. Note: there is\nno support for inline value specification, by design.\n\nOptionally takes :gen generator-fn, which must be a fn of no args that\nreturns a test.check generator.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/keys"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "keys*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L724",
   :line 724,
   :var-type "macro",
   :arglists ([& kspecs]),
   :doc
   "takes the same arguments as spec/keys and returns a regex op that matches sequences of key/values,\nconverts them into a map, and conforms that map with a corresponding\nspec/keys call:\n\nuser=> (s/conform (s/keys :req-un [::a ::c]) {:a 1 :c 2})\n{:a 1, :c 2}\nuser=> (s/conform (s/keys* :req-un [::a ::c]) [:a 1 :c 2])\n{:a 1, :c 2}\n\nthe resulting regex op can be composed into a larger regex:\n\nuser=> (s/conform (s/cat :i1 integer? :m (s/keys* :req-un [::a ::c]) :i2 integer?) [42 :a 1 :c 2 :d 4 99])\n{:i1 42, :m {:a 1, :c 2, :d 4}, :i2 99}",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/keys*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "map-of",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L483",
   :line 483,
   :var-type "macro",
   :arglists ([kpred vpred & opts]),
   :doc
   "Returns a spec for a map whose keys satisfy kpred and vals satisfy\nvpred. Unlike 'every-kv', map-of will exhaustively conform every\nvalue.\n\nSame options as 'every', :kind defaults to map?, with the addition of:\n\n:conform-keys - conform keys as well as values (default false)\n\nSee also - every-kv",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/map-of"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "merge",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L421",
   :line 421,
   :var-type "macro",
   :arglists ([& pred-forms]),
   :doc
   "Takes map-validating specs (e.g. 'keys' specs) and\nreturns a spec that returns a conformed map satisfying all of the\nspecs.  Unlike 'and', merge can generate maps satisfying the\nunion of the predicates.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/merge"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "multi-spec",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L661",
   :line 661,
   :var-type "macro",
   :arglists ([mm retag]),
   :doc
   "Takes the name of a spec/predicate-returning multimethod and a\ntag-restoring keyword or fn (retag).  Returns a spec that when\nconforming or explaining data will pass it to the multimethod to get\nan appropriate spec. You can e.g. use multi-spec to dynamically and\nextensibly associate specs with 'tagged' data (i.e. data where one\nof the fields indicates the shape of the rest of the structure).\n\n(defmulti mspec :tag)\n\nThe methods should ignore their argument and return a predicate/spec:\n(defmethod mspec :int [_] (s/keys :req-un [::tag ::i]))\n\nretag is used during generation to retag generated values with\nmatching tags. retag can either be a keyword, at which key the\ndispatch-tag will be assoc'ed, or a fn of generated value and\ndispatch-tag that should return an appropriately retagged value.\n\nNote that because the tags themselves comprise an open set,\nthe tag key spec cannot enumerate the values, but can e.g.\ntest for keyword?.\n\nNote also that the dispatch values of the multimethod will be\nincluded in the path, i.e. in reporting and gen overrides, even\nthough those values are not evident in the spec.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/multi-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "nest",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L543",
   :line 543,
   :var-type "macro",
   :arglists ([re]),
   :doc
   "takes a regex op and returns a non-regex op that describes a nested\nsequential collection.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/nest"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "nilable",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L747",
   :line 747,
   :var-type "macro",
   :arglists ([pred]),
   :doc "returns a spec that accepts nil and values satisfying pred",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/nilable"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "nonconforming",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L741",
   :line 741,
   :var-type "macro",
   :arglists ([spec]),
   :doc
   "takes a spec and returns a spec that has the same properties except\n'conform' returns the original (not the conformed) value.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/nonconforming"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "or",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L698",
   :line 698,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc
   "Takes key+pred pairs, e.g.\n\n(s/or :even even? :small #(< % 42))\n\nReturns a destructuring spec that returns a map entry containing the\nkey of the first matching pred and the corresponding value. Thus the\n'key' and 'val' functions can be used to refer generically to the\ncomponents of the tagged return.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/or"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "regex?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L86",
   :line 86,
   :var-type "function",
   :arglists ([x]),
   :doc
   "returns x if x is a (clojure.spec) regex op, else logical false",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/regex?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "register",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L388",
   :line 388,
   :var-type "function",
   :arglists ([k s]),
   :doc
   "Given a namespace-qualified keyword or resolvable symbol k, and a\nspec-name or spec object, makes an entry in the registry mapping k\nto the spec. Use nil to remove an entry in the registry for k.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/register"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "registry",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L40",
   :line 40,
   :var-type "function",
   :arglists ([]),
   :doc
   "Returns the registry map, prefer 'get-spec' to lookup a spec by name",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/registry"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "schema",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L371",
   :line 371,
   :var-type "macro",
   :arglists ([& coll]),
   :doc
   "Given a literal vector or map schema, expand to a proper explicated spec\nform, which when evaluated yields a schema object.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/schema"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "schema*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L199",
   :line 199,
   :var-type "function",
   :arglists ([sform]),
   :doc
   "Returns a schema object given a fully-qualified schema definition.\nIf needed use 'explicate' to qualify forms.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/schema*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "schema?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L51",
   :line 51,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns x if x is a schema object, else logical false",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/schema?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "select",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L652",
   :line 652,
   :var-type "macro",
   :arglists ([keyset selection]),
   :doc
   "Takes a keyset and a selection pattern and returns a spec that\nvalidates a map. The keyset specifies what keys may be in the map\nand the specs to use if the keys are unqualified. The selection\npattern indicates what keys must be in the map, and any nested\nmaps.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/select"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "spec",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L382",
   :line 382,
   :var-type "macro",
   :arglists ([s]),
   :doc
   "Given a function symbol, set of constants, or anonymous function,\nreturns a spec object.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "spec*",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L183",
   :line 183,
   :var-type "function",
   :arglists ([qform]),
   :doc
   "Returns a spec object given a fully-qualified spec op form, symbol, set,\nor registry identifier. If needed, use 'explicate' to qualify forms.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/spec*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "spec?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L45",
   :line 45,
   :var-type "function",
   :arglists ([x]),
   :doc "returns x if x is a spec object, else logical false",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/spec?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "tuple",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L690",
   :line 690,
   :var-type "macro",
   :arglists ([& preds]),
   :doc
   "takes one or more preds and returns a spec for a tuple, a vector\nwhere each element conforms to the corresponding pred. Each element\nwill be referred to in paths using its ordinal.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/tuple"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "unform",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L217",
   :line 217,
   :var-type "function",
   :arglists ([spec x]),
   :doc
   "Given a spec and a value created by or compliant with a call to\n'conform' with the same spec, returns a value with all conform\ndestructuring undone.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/unform"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "union",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L377",
   :line 377,
   :var-type "macro",
   :arglists ([& schemas]),
   :doc "Takes schemas and unions them, returning a schema object",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/union"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "valid?",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L313",
   :line 313,
   :var-type "function",
   :arglists ([spec x]),
   :doc "Helper function that returns true when x is valid for spec.",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/valid?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj",
   :name "with-gen",
   :file "src/main/clojure/clojure/spec_alpha2.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2.clj#L416",
   :line 416,
   :var-type "macro",
   :arglists ([spec gen-fn]),
   :doc
   "Takes a spec and a no-arg, generator-returning fn and returns a version of that spec that uses that generator",
   :namespace "clojure.spec-alpha2",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2/with-gen"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "any",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/any",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/any"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "any-printable",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/any-printable",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/any-printable"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "bind",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/bind",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/bind"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "boolean",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/boolean",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/boolean"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "bytes",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/bytes",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/bytes"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "cat",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L122",
   :line 122,
   :var-type "function",
   :arglists ([& gens]),
   :doc
   "Returns a generator of a sequence catenated from results of\ngens, each of which should generate something sequential.",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/cat"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "char",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/char"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "char-alpha",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char-alpha",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/char-alpha"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "char-alphanumeric",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char-alphanumeric",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/char-alphanumeric"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "char-ascii",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char-ascii",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/char-ascii"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "choose",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/choose",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/choose"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "delay",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L61",
   :line 61,
   :var-type "macro",
   :arglists ([& body]),
   :doc
   "given body that returns a generator, returns a\ngenerator that delegates to that, but delays\ncreation until used.",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/delay"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "double",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/double",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/double"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "double*",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/double*",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/double*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "elements",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/elements",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/elements"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "fmap",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/fmap",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/fmap"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "for-all*",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L36",
   :line 36,
   :var-type "function",
   :arglists ([& args]),
   :doc "Dynamically loaded clojure.test.check.properties/for-all*.",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/for-all*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "frequency",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/frequency",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/frequency"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "gen-for-name",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L68",
   :line 68,
   :var-type "function",
   :arglists ([s]),
   :doc "Dynamically loads test.check generator named s.",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/gen-for-name"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "gen-for-pred",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L190",
   :line 190,
   :var-type "function",
   :arglists ([pred]),
   :doc
   "Given a predicate, returns a built-in generator if one exists.",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/gen-for-pred"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "generate",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L50",
   :line 50,
   :var-type "function",
   :arglists ([generator]),
   :doc "Generate a single value using generator.",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/generate"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "hash-map",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/hash-map",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/hash-map"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "int",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/int",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/int"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "keyword",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/keyword",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/keyword"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "keyword-ns",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/keyword-ns",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/keyword-ns"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "large-integer",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/large-integer",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/large-integer"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "large-integer*",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/large-integer*",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/large-integer*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "list",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/list",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/list"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "map",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/map",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/map"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "not-empty",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/not-empty",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/not-empty"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "one-of",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/one-of",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/one-of"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "ratio",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/ratio",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/ratio"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "return",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/return",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/return"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "sample",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/sample",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/sample"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "set",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/set",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/set"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "shuffle",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/shuffle",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/shuffle"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "simple-type",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/simple-type",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/simple-type"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "simple-type-printable",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Fn returning clojure.test.check.generators/simple-type-printable",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/simple-type-printable"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "string",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/string",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/string"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "string-alphanumeric",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Fn returning clojure.test.check.generators/string-alphanumeric",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/string-alphanumeric"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "string-ascii",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/string-ascii",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/string-ascii"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "such-that",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/such-that",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/such-that"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "symbol",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/symbol",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/symbol"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "symbol-ns",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/symbol-ns",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/symbol-ns"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "tuple",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/tuple",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/tuple"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "uuid",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/uuid",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/uuid"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "vector",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/vector",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/vector"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj",
   :name "vector-distinct",
   :file "src/main/clojure/clojure/spec_alpha2/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/vector-distinct",
   :namespace "clojure.spec-alpha2.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.gen/vector-distinct"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/protocols.clj",
   :name "Select",
   :file "src/main/clojure/clojure/spec_alpha2/protocols.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/protocols.clj#L23",
   :line 23,
   :var-type "var",
   :arglists nil,
   :doc "Marker protocol for selects",
   :namespace "clojure.spec-alpha2.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.protocols/Select"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/protocols.clj",
   :name "Schema",
   :file "src/main/clojure/clojure/spec_alpha2/protocols.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/protocols.clj#L20",
   :line 20,
   :var-type "protocol",
   :arglists nil,
   :doc nil,
   :namespace "clojure.spec-alpha2.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.protocols/Schema"}
  {:raw-source-url nil,
   :name "keyspecs*",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([spec]),
   :doc "Returns map of key to symbolic spec",
   :namespace "clojure.spec-alpha2.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.protocols/keyspecs*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "abbrev-result",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L436",
   :line 436,
   :var-type "function",
   :arglists ([x]),
   :doc
   "Given a check result, returns an abbreviated version\nsuitable for summary use.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/abbrev-result"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "check",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L370",
   :line 370,
   :var-type "function",
   :arglists ([] [sym-or-syms] [sym-or-syms opts]),
   :doc
   "Run generative tests for spec conformance on vars named by\nsym-or-syms, a symbol or collection of symbols. If sym-or-syms\nis not specified, check all checkable vars.\n\nThe opts map includes the following optional keys, where stc\naliases clojure.spec.test.check: \n\n::stc/opts  opts to flow through test.check/quick-check\n:gen        map from spec names to generator overrides\n\nThe ::stc/opts include :num-tests in addition to the keys\ndocumented by test.check. Generator overrides are passed to\nspec/gen when generating function args.\n\nReturns a lazy sequence of check result maps with the following\nkeys\n\n:spec       the spec tested\n:sym        optional symbol naming the var tested\n:failure    optional test failure\n::stc/ret   optional value returned by test.check/quick-check\n\nThe value for :failure can be any exception. Exceptions thrown by\nspec itself will have an ::s/failure value in ex-data:\n\n:check-failed   at least one checked return did not conform\n:no-args-spec   no :args spec provided\n:no-fn          no fn provided\n:no-fspec       no fspec provided\n:no-gen         unable to generate :args\n:instrument     invalid args detected by instrument",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/check"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "check-fn",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L353",
   :line 353,
   :var-type "function",
   :arglists ([f spec] [f spec opts]),
   :doc
   "Runs generative tests for fn f using spec and opts. See\n'check' for options and return.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/check-fn"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "checkable-syms",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L361",
   :line 361,
   :var-type "function",
   :arglists ([] [opts]),
   :doc
   "Given an opts map as per check, returns the set of syms that\ncan be checked.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/checkable-syms"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "enumerate-namespace",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L41",
   :line 41,
   :var-type "function",
   :arglists ([ns-sym-or-syms]),
   :doc
   "Given a symbol naming an ns, or a collection of such symbols,\nreturns the set of all symbols naming vars in those nses.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/enumerate-namespace"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "instrument",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L208",
   :line 208,
   :var-type "function",
   :arglists ([] [sym-or-syms] [sym-or-syms opts]),
   :doc
   "Instruments the vars named by sym-or-syms, a symbol or collection\nof symbols, or all instrumentable vars if sym-or-syms is not\nspecified.\n\nIf a var has an :args fn-spec, sets the var's root binding to a\nfn that checks arg conformance (throwing an exception on failure)\nbefore delegating to the original fn.\n\nThe opts map can be used to override registered specs, and/or to\nreplace fn implementations entirely. Opts for symbols not included\nin sym-or-syms are ignored. This facilitates sharing a common\noptions map across many different calls to instrument.\n\nThe opts map may have the following keys:\n\n  :spec     a map from var-name symbols to override specs\n  :stub     a set of var-name symbols to be replaced by stubs\n  :gen      a map from spec names to generator overrides\n  :replace  a map from var-name symbols to replacement fns\n\n:spec overrides registered fn-specs with specs your provide. Use\n:spec overrides to provide specs for libraries that do not have\nthem, or to constrain your own use of a fn to a subset of its\nspec'ed contract.\n\n:stub replaces a fn with a stub that checks :args, then uses the\n:ret spec to generate a return value.\n\n:gen overrides are used only for :stub generation.\n\n:replace replaces a fn with a fn that checks args conformance, then\ninvokes the fn you provide, enabling arbitrary stubbing and mocking.\n\n:spec can be used in combination with :stub or :replace.\n\nReturns a collection of syms naming the vars instrumented.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/instrument"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "instrumentable-syms",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L197",
   :line 197,
   :var-type "function",
   :arglists ([] [opts]),
   :doc
   "Given an opts map as per instrument, returns the set of syms\nthat can be instrumented.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/instrumentable-syms"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "summarize-results",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L446",
   :line 446,
   :var-type "function",
   :arglists ([check-results] [check-results summary-result]),
   :doc
   "Given a collection of check-results, e.g. from 'check', pretty\nprints the summary-result (default abbrev-result) of each.\n\nReturns a map with :total, the total number of results, plus a\nkey with a count for each different :type of result.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/summarize-results"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "unstrument",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L257",
   :line 257,
   :var-type "function",
   :arglists ([] [sym-or-syms]),
   :doc
   "Undoes instrument on the vars named by sym-or-syms, specified\nas in instrument. With no args, unstruments all instrumented vars.\nReturns a collection of syms naming the vars unstrumented.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/unstrument"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj",
   :name "with-instrument-disabled",
   :file "src/main/clojure/clojure/spec_alpha2/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/0a96d224df8ff5ba0a59a46a8387173585799476/src/main/clojure/clojure/spec_alpha2/test.clj#L65",
   :line 65,
   :var-type "macro",
   :arglists ([& body]),
   :doc "Disables instrument's checking of calls, within a scope.",
   :namespace "clojure.spec-alpha2.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.spec-alpha2.test/with-instrument-disabled"})}
