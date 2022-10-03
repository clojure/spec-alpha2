{:namespaces
 ({:doc
   "The spec library specifies the structure of data or functions and provides\noperations to validate, conform, explain, describe, and generate data based on\nthe specs.\n\nRationale: https://clojure.org/about/spec\nGuide: https://clojure.org/guides/spec",
   :name "clojure.alpha.spec",
   :wiki-url "https://clojure.github.io/spec-alpha2/index.html",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj"}
  {:doc nil,
   :name "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2/index.html#clojure.alpha.spec.gen",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj"}
  {:doc nil,
   :name "clojure.alpha.spec.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2/index.html#clojure.alpha.spec.protocols",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/7c708d063b6ea925fd406f87e08f508b7ed8c91d/src/main/clojure/clojure/alpha/spec/protocols.clj"}
  {:doc nil,
   :name "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2/index.html#clojure.alpha.spec.test",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "&",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L586",
   :line 586,
   :var-type "macro",
   :arglists ([re & preds]),
   :doc
   "takes a regex op re, and predicates. Returns a regex-op that consumes\ninput as per re but subjects the resulting value to the\nconjunction of the predicates, and any conforming they might perform.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/&"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L546",
   :line 546,
   :var-type "macro",
   :arglists ([pred-form]),
   :doc
   "Returns a regex op that matches zero or more values matching\npred. Produces a vector of matches iff there is at least one match",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "*coll-check-limit*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L37",
   :dynamic true,
   :line 37,
   :var-type "var",
   :arglists nil,
   :doc
   "The number of elements validated in a collection spec'ed with 'every'",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/*coll-check-limit*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "*coll-error-limit*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L41",
   :dynamic true,
   :line 41,
   :var-type "var",
   :arglists nil,
   :doc
   "The number of errors reported by explain in a collection spec'ed with 'every'",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/*coll-error-limit*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "*compile-asserts*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L850",
   :dynamic true,
   :line 850,
   :var-type "var",
   :arglists nil,
   :doc
   "If true, compiler will enable spec asserts, which are then\nsubject to runtime control via check-asserts? If false, compiler\nwill eliminate all spec assert overhead. See 'assert'.\n\nInitially set to boolean value of clojure.spec.compile-asserts\nsystem property. Defaults to true.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/*compile-asserts*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "*fspec-iterations*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L33",
   :dynamic true,
   :line 33,
   :var-type "var",
   :arglists nil,
   :doc
   "The number of times an anonymous fn specified by fspec will be (generatively) tested during conform",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/*fspec-iterations*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "*recursion-limit*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L27",
   :dynamic true,
   :line 27,
   :var-type "var",
   :arglists nil,
   :doc
   "A soft limit on how many times a branching spec (or/alt/*/opt-keys/multi-spec)\ncan be recursed through during generation. After this a\nnon-recursive branch will be chosen.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/*recursion-limit*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "+",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L552",
   :line 552,
   :var-type "macro",
   :arglists ([pred-form]),
   :doc
   "Returns a regex op that matches one or more values matching\npred. Produces a vector of matches",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/+"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L558",
   :line 558,
   :var-type "macro",
   :arglists ([pred-form]),
   :doc
   "Returns a regex op that matches zero or one value matching\npred. Produces a single value (not a collection) if matched.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "alt",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L564",
   :line 564,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc
   "Takes key+pred pairs, e.g.\n\n(s/alt :even even? :small #(< % 42))\n\nReturns a regex op that returns a map entry containing the key of the\nfirst matching pred and the corresponding value. Thus the\n'key' and 'val' functions can be used to refer generically to the\ncomponents of the tagged return",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/alt"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "and",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L762",
   :line 762,
   :var-type "macro",
   :arglists ([& pred-forms]),
   :doc
   "Takes predicate/spec-forms, e.g.\n\n(s/and int? even? #(< % 42))\n\nReturns a spec that returns the conformed value. Successive\nconformed values propagate through rest of predicates.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/and"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "and-",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L772",
   :line 772,
   :var-type "macro",
   :arglists ([& pred-forms]),
   :doc
   "Takes predicate/spec-forms, e.g.\n\n(s/and- (s/cat :i int?) #(pos? (first %)))\n\nReturns a spec that validates all preds on and returns the conformed value of\nthe first pred. Conformed values are NOT propagated through rest of predicates.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/and-"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "assert",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L886",
   :line 886,
   :var-type "macro",
   :arglists ([spec x]),
   :doc
   "spec-checking assert expression. Returns x if x is valid? according\nto spec, else throws an ex-info with explain-data plus ::failure of\n:assertion-failed.\n\nCan be disabled at either compile time or runtime:\n\nIf *compile-asserts* is false at compile time, compiles to x. Defaults\nto value of 'clojure.spec.compile-asserts' system property, or true if\nnot set.\n\nIf (check-asserts?) is false at runtime, always returns x. Defaults to\nvalue of 'clojure.spec.check-asserts' system property, or false if not\nset. You can toggle check-asserts? with (check-asserts bool).",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/assert"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "assert*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L875",
   :line 875,
   :var-type "function",
   :arglists ([spec x]),
   :doc "Do not call this directly, use 'assert'.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/assert*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "cat",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L576",
   :line 576,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc
   "Takes key+pred pairs, e.g.\n\n(s/cat :e even? :o odd?)\n\nReturns a regex op that matches (all) values in sequence, returning a map\ncontaining the keys of each pred and the corresponding value.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/cat"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "cats",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L1033",
   :line 1033,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc "Like s/cat, but constrain to only seqs",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/cats"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "catv",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L1032",
   :line 1032,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc "Like s/cat, but constrain to only vectors",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/catv"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "check-asserts",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L866",
   :line 866,
   :var-type "function",
   :arglists ([flag]),
   :doc
   "Enable or disable spec asserts that have been compiled\nwith '*compile-asserts*' true.  See 'assert'.\n\nInitially set to boolean value of clojure.spec.check-asserts\nsystem property. Defaults to false.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/check-asserts"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "check-asserts?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L861",
   :line 861,
   :var-type "function",
   :arglists ([]),
   :doc "Returns the value set by check-asserts.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/check-asserts?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "coll-of",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L521",
   :line 521,
   :var-type "macro",
   :arglists ([pred & opts]),
   :doc
   "Returns a spec for a collection of items satisfying pred. Unlike\n'every', coll-of will exhaustively conform every value.\n\nSame options as 'every'. conform will produce a collection\ncorresponding to :into if supplied, else will match the input collection,\navoiding rebuilding when possible.\n\nSee also - every, map-of",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/coll-of"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "conform",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L237",
   :line 237,
   :var-type "function",
   :arglists ([spec x] [spec x settings]),
   :doc
   "Given a spec and a value, returns :clojure.alpha.spec/invalid\n\tif value does not match spec, else the (possibly destructured) value.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/conform"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "conformer",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L599",
   :line 599,
   :var-type "macro",
   :arglists ([f] [f unf]),
   :doc
   "takes a predicate function with the semantics of conform i.e. it should return either a\n(possibly converted) value or :clojure.alpha.spec/invalid, and returns a\nspec that uses it as a predicate/conformer. Optionally takes a\nsecond fn that does unform of result of first",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/conformer"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "create-spec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L146",
   :line 146,
   :var-type "multimethod",
   :arglists nil,
   :doc
   "Create a spec object from an explicated spec map. This is an extension\npoint for adding new spec ops. Generally, consumers should instead call\n`resolve-spec`.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/create-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "def",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L440",
   :line 440,
   :var-type "macro",
   :arglists ([k spec-form]),
   :doc
   "Given a namespace-qualified keyword or resolvable symbol k, and a\nspec-name or symbolic spec, makes an entry in the registry mapping k\nto the spec. Use nil to remove an entry in the registry for k.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/def"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "defcompop",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L1001",
   :line 1001,
   :var-type "macro",
   :arglists ([op-name doc-string? spec-op preds+]),
   :doc
   "Defines a new composite spec with op-name and args same as spec-op.\nThe new spec takes the same args as spec-op, and also ensures the preds\nare satisfied.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/defcompop"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "defop",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L930",
   :line 930,
   :var-type "macro",
   :arglists ([op-name doc-string? opts? [params*] form]),
   :doc
   "Defines a new spec op with op-name defined by the form. Defines a macro for op-name with docstring that\nexpands to a call to resolve-spec with the explicated form. args are replaced in the form. Creates a create-spec\nmethod implementation for op-name that creates a spec whose body is form.\n\nOpts allowed:\n :gen - takes a no-arg function returning a generator to use",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/defop"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "describe",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L279",
   :line 279,
   :var-type "function",
   :arglists ([spec]),
   :doc "returns an abbreviated description of the spec as data",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/describe"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "double-in",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L986",
   :line 986,
   :var-type "macro",
   :arglists ([& {:keys [infinite? NaN? min max :as m]}]),
   :doc
   "Specs a 64-bit floating point number. Options:\n\n:infinite? - whether +/- infinity allowed (default true)\n:NaN?      - whether NaN allowed (default true)\n:min       - minimum value (inclusive, default none)\n:max       - maximum value (inclusive, default none)",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/double-in"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "every",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L479",
   :line 479,
   :var-type "macro",
   :arglists
   ([pred & {:keys [:clojure.alpha.spec/describe], :as opts}]),
   :doc
   "takes a pred and validates collection elements against that pred.\n\nNote that 'every' does not do exhaustive checking, rather it samples\n*coll-check-limit* elements. Nor (as a result) does it do any\nconforming of elements. 'explain' will report at most *coll-error-limit*\nproblems.  Thus 'every' should be suitable for potentially large\ncollections.\n\nTakes several kwargs options that further constrain the collection:\n\n:kind - a pred that the collection type must satisfy, e.g. vector?\n      (default nil) Note that if :kind is specified and :into is\n      not, this pred must generate in order for every to generate.\n:count - specifies coll has exactly this count (default nil)\n:min-count, :max-count - coll has count (<= min-count count max-count) (defaults nil)\n:distinct - all the elements are distinct (default nil)\n\nAnd additional args that control gen\n\n:gen-max - the maximum coll size to generate (default 20)\n:into - one of [], (), {}, #{} - the default collection to generate into\n    (default: empty coll as generated by :kind pred if supplied, else [])\n\nOptionally takes :gen generator-fn, which must be a fn of no args that\nreturns a test.check generator\n\nSee also - coll-of, every-kv",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/every"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "every-kv",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L512",
   :line 512,
   :var-type "macro",
   :arglists ([kpred vpred & opts]),
   :doc
   "like 'every' but takes separate key and val preds and works on associative collections.\n\nSame options as 'every', :into defaults to {}\n\nSee also - map-of",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/every-kv"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "exercise",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L813",
   :line 813,
   :var-type "function",
   :arglists ([spec] [spec n] [spec n overrides]),
   :doc
   "generates a number (default 10) of values compatible with spec and maps conform over them,\nreturning a sequence of [val conformed-val] tuples. Optionally takes\na generator overrides map as per gen",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/exercise"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "exercise-fn",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L822",
   :line 822,
   :var-type "function",
   :arglists ([sym] [sym n] [sym-or-f n fspec]),
   :doc
   "exercises the fn named by sym (a symbol) by applying it to\nn (default 10) generated samples of its args spec. When fspec is\nsupplied its arg spec is used, and sym-or-f can be a fn.  Returns a\nsequence of tuples of [args ret]. ",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/exercise-fn"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "expand-spec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L137",
   :line 137,
   :var-type "multimethod",
   :arglists nil,
   :doc
   "Create a symbolic spec map from an explicated spec form. This is an\nextension point for adding new spec ops. Generally, consumers should\ninstead call `resolve-spec`. For anything other than symbolic spec maps,\nreturn the same object unchanged.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/expand-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "explain",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L336",
   :line 336,
   :var-type "function",
   :arglists ([spec x] [spec x settings]),
   :doc
   "Given a spec and a value that fails to conform, prints an explanation to *out*.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/explain"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "explain-data",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L291",
   :line 291,
   :var-type "function",
   :arglists ([spec x] [spec x settings]),
   :doc
   "Given a spec and a value x which ought to conform, returns nil if x\nconforms, else a map with at least the key ::problems whose value is\na collection of problem-maps, where problem-map has at least :path :pred and :val\nkeys describing the predicate and the value that failed at that\npath.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/explain-data"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "explain-out",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L330",
   :line 330,
   :var-type "function",
   :arglists ([ed]),
   :doc
   "Prints explanation data (per 'explain-data') to *out* using the printer in *explain-out*,\nby default explain-printer.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/explain-out"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "explain-printer",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L303",
   :line 303,
   :var-type "function",
   :arglists ([ed]),
   :doc
   "Default printer for explain-data. nil indicates a successful validation.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/explain-printer"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "explain-str",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L343",
   :line 343,
   :var-type "function",
   :arglists ([spec x] [spec x settings]),
   :doc
   "Given a spec and a value that fails to conform, returns an explanation as a string.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/explain-str"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "explicate",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L396",
   :line 396,
   :var-type "function",
   :arglists ([ns-name form]),
   :doc
   "Return a fully-qualified form given a namespace name context and a form",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/explicate"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "fdef",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L636",
   :line 636,
   :var-type "macro",
   :arglists ([fn-sym & specs]),
   :doc
   "Takes a symbol naming a function, and one or more of the following:\n\n:args A regex spec for the function arguments as they were a list to be\n  passed to apply - in this way, a single spec can handle functions with\n  multiple arities\n:ret A spec for the function's return value\n:fn A spec of the relationship between args and ret - the\n  value passed is {:args conformed-args :ret conformed-ret} and is\n  expected to contain predicates that relate those values\n\nQualifies fn-sym with resolve, or using *ns* if no resolution found.\nRegisters an fspec in the global registry, where it can be retrieved\nby calling get-spec with the var or fully-qualified symbol.\n\nOnce registered, function specs are included in doc, checked by\ninstrument, tested by the runner clojure.alpha.spec.test/check, and (if\na macro) used to explain errors during macroexpansion.\n\nNote that :fn specs require the presence of :args and :ret specs to\nconform values, and so :fn specs will be ignored if :args or :ret\nare missing.\n\nReturns the qualified fn-sym.\n\nFor example, to register function specs for the symbol function:\n\n(s/fdef clojure.core/symbol\n  :args (s/alt :separate (s/cat :ns string? :n string?)\n               :str string?\n               :sym symbol?)\n  :ret symbol?)",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/fdef"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "form",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L254",
   :line 254,
   :var-type "function",
   :arglists ([spec]),
   :doc "returns the spec as data",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/form"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "fspec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L607",
   :line 607,
   :var-type "macro",
   :arglists ([& opts]),
   :doc
   "takes :args :ret and (optional) :fn kwargs whose values are preds\nand returns a spec whose conform/explain take a fn and validates it\nusing generative testing. The conformed value is always the fn itself.\n\nSee 'fdef' for a single operation that creates an fspec and\nregisters it, as well as a full description of :args, :ret and :fn\n\nfspecs can generate functions that validate the arguments and\nfabricate a return value compliant with the :ret spec, ignoring\nthe :fn spec if present.\n\nOptionally takes :gen generator-fn, which must be a fn of no args\nthat returns a test.check generator.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/fspec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "gen",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L373",
   :line 373,
   :var-type "function",
   :arglists ([spec] [spec overrides]),
   :doc
   "Given a spec, returns the generator for it, or throws if none can\nbe constructed. Optionally an overrides map can be provided which\nshould map spec names or paths (vectors of keywords) to no-arg\ngenerator-creating fns. These will be used instead of the generators at those\nnames/paths. Note that parent generator (in the spec or overrides\nmap) will supersede those of any subtrees. A generator for a regex\nop must always return a sequential collection (i.e. a generator for\ns/? should return either an empty sequence/vector or a\nsequence/vector with one item in it)",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/gen"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "get-spec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L63",
   :line 63,
   :var-type "function",
   :arglists ([k]),
   :doc "Returns spec registered for keyword/symbol/var k, or nil.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/get-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "inst-in",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L971",
   :line 971,
   :var-type "macro",
   :arglists ([start end]),
   :doc
   "Returns a spec that validates insts in the range from start\n(inclusive) to end (exclusive).",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/inst-in"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "inst-in-range?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L836",
   :line 836,
   :var-type "function",
   :arglists ([start end inst]),
   :doc "Return true if inst at or after start and before end",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/inst-in-range?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "int-in",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L979",
   :line 979,
   :var-type "macro",
   :arglists ([start end]),
   :doc
   "Returns a spec that validates fixed precision integers in the\nrange from start (inclusive) to end (exclusive).",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/int-in"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "int-in-range?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L843",
   :line 843,
   :var-type "function",
   :arglists ([start end val]),
   :doc
   "Return true if start <= val, val < end and val is a fixed\nprecision integer.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/int-in-range?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "invalid?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L115",
   :line 115,
   :var-type "function",
   :arglists ([ret]),
   :doc "tests the validity of a conform return value",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/invalid?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "keys",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L671",
   :line 671,
   :var-type "macro",
   :arglists ([& ks]),
   :doc
   "Creates and returns a map validating spec. :req and :opt are both\nvectors of namespaced-qualified keywords. The validator will ensure\nthe :req keys are present. The :opt keys serve as documentation and\nmay be used by the generator.\n\nThe :req key vector supports 'and' and 'or' for key groups:\n\n(s/keys :req [::x ::y (or ::secret (and ::user ::pwd))] :opt [::z])\n\nThere are also -un versions of :req and :opt. These allow\nyou to connect unqualified keys to specs.  In each case, fully\nqualified keywords are passed, which name the specs, but unqualified\nkeys (with the same name component) are expected and checked at\nconform-time, and generated during gen:\n\n(s/keys :req-un [:my.ns/x :my.ns/y])\n\nThe above says keys :x and :y are required, and will be validated\nand generated by specs (if they exist) named :my.ns/x :my.ns/y\nrespectively.\n\nIn addition, the values of *all* namespace-qualified keys will be validated\n(and possibly destructured) by any registered specs. Note: there is\nno support for inline value specification, by design.\n\nOptionally takes :gen generator-fn, which must be a fn of no args that\nreturns a test.check generator.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/keys"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "keys*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L785",
   :line 785,
   :var-type "macro",
   :arglists ([& kspecs]),
   :doc
   "takes the same arguments as spec/keys and returns a regex op that matches sequences of key/values,\nconverts them into a map, and conforms that map with a corresponding\nspec/keys call:\n\nuser=> (s/conform (s/keys :req-un [::a ::c]) {:a 1 :c 2})\n{:a 1, :c 2}\nuser=> (s/conform (s/keys* :req-un [::a ::c]) [:a 1 :c 2])\n{:a 1, :c 2}\n\nthe resulting regex op can be composed into a larger regex:\n\nuser=> (s/conform (s/cat :i1 integer? :m (s/keys* :req-un [::a ::c]) :i2 integer?) [42 :a 1 :c 2 :d 4 99])\n{:i1 42, :m {:a 1, :c 2, :d 4}, :i2 99}",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/keys*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "map-of",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L533",
   :line 533,
   :var-type "macro",
   :arglists ([kpred vpred & opts]),
   :doc
   "Returns a spec for a map whose keys satisfy kpred and vals satisfy\nvpred. Unlike 'every-kv', map-of will exhaustively conform every\nvalue.\n\nSame options as 'every', :kind defaults to map?, with the addition of:\n\n:conform-keys - conform keys as well as values (default false)\n\nSee also - every-kv",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/map-of"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "merge",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L471",
   :line 471,
   :var-type "macro",
   :arglists ([& pred-forms]),
   :doc
   "Takes map-validating specs (e.g. 'keys' specs) and\nreturns a spec that returns a conformed map satisfying all of the\nspecs.  Unlike 'and', merge can generate maps satisfying the\nunion of the predicates.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/merge"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "multi-spec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L711",
   :line 711,
   :var-type "macro",
   :arglists ([mm retag]),
   :doc
   "Takes the name of a spec/predicate-returning multimethod and a\ntag-restoring keyword or fn (retag).  Returns a spec that when\nconforming or explaining data will pass it to the multimethod to get\nan appropriate spec. You can e.g. use multi-spec to dynamically and\nextensibly associate specs with 'tagged' data (i.e. data where one\nof the fields indicates the shape of the rest of the structure).\n\n(defmulti mspec :tag)\n\nThe methods should ignore their argument and return a predicate/spec:\n(defmethod mspec :int [_] (s/keys :req-un [::tag ::i]))\n\nretag is used during generation to retag generated values with\nmatching tags. retag can either be a keyword, at which key the\ndispatch-tag will be assoc'ed, or a fn of generated value and\ndispatch-tag that should return an appropriately retagged value.\n\nNote that because the tags themselves comprise an open set,\nthe tag key spec cannot enumerate the values, but can e.g.\ntest for keyword?.\n\nNote also that the dispatch values of the multimethod will be\nincluded in the path, i.e. in reporting and gen overrides, even\nthough those values are not evident in the spec.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/multi-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "nest",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L593",
   :line 593,
   :var-type "macro",
   :arglists ([re]),
   :doc
   "takes a regex op and returns a non-regex op that describes a nested\nsequential collection.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/nest"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "nilable",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L808",
   :line 808,
   :var-type "macro",
   :arglists ([pred]),
   :doc "returns a spec that accepts nil and values satisfying pred",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/nilable"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "nonconforming",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L802",
   :line 802,
   :var-type "macro",
   :arglists ([spec]),
   :doc
   "takes a spec and returns a spec that has the same properties except\n'conform' returns the original (not the conformed) value.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/nonconforming"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "or",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L748",
   :line 748,
   :var-type "macro",
   :arglists ([& key-pred-forms]),
   :doc
   "Takes key+pred pairs, e.g.\n\n(s/or :even even? :small #(< % 42))\n\nReturns a destructuring spec that returns a map entry containing the\nkey of the first matching pred and the corresponding value. Thus the\n'key' and 'val' functions can be used to refer generically to the\ncomponents of the tagged return.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/or"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "regex?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L93",
   :line 93,
   :var-type "function",
   :arglists ([x]),
   :doc
   "returns x if x is a (clojure.spec) regex op, else logical false",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/regex?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "register",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L429",
   :line 429,
   :var-type "function",
   :arglists ([k s]),
   :doc
   "Given a namespace-qualified keyword or resolvable symbol k, and a\nspec-name or spec object, makes an entry in the registry mapping k\nto the spec. Use nil to remove an entry in the registry for k.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/register"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "registry",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L47",
   :line 47,
   :var-type "function",
   :arglists ([]),
   :doc
   "Returns the registry map, prefer 'get-spec' to lookup a spec by name",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/registry"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "resolve-fn",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L203",
   :line 203,
   :var-type "function",
   :arglists ([fn-form]),
   :doc
   "Resolves a symbolic function to a function object (predicate).",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/resolve-fn"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "resolve-spec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L208",
   :line 208,
   :var-type "function",
   :arglists ([qform]),
   :doc
   "Returns a spec object given a fully-qualified spec op form, symbol, set,\nor registry identifier. If needed, use 'explicate' to qualify forms.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/resolve-spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "schema",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L412",
   :line 412,
   :var-type "macro",
   :arglists ([& coll]),
   :doc
   "Given a literal vector or map schema, expand to a proper explicated spec\nform, which when evaluated yields a schema object.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/schema"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "schema*",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L225",
   :line 225,
   :var-type "function",
   :arglists ([sform]),
   :doc
   "Returns a schema object given a fully-qualified schema definition.\nIf needed use 'explicate' to qualify forms.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/schema*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "schema?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L58",
   :line 58,
   :var-type "function",
   :arglists ([x]),
   :doc "Returns x if x is a schema object, else logical false",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/schema?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "select",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L702",
   :line 702,
   :var-type "macro",
   :arglists ([keyset selection]),
   :doc
   "Takes a keyset and a selection pattern and returns a spec that\nvalidates a map. The keyset specifies what keys may be in the map\nand the specs to use if the keys are unqualified. The selection\npattern indicates what keys must be in the map, and any nested\nmaps.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/select"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "spec",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L423",
   :line 423,
   :var-type "macro",
   :arglists ([s]),
   :doc
   "Given a function symbol, set of constants, or anonymous function,\nreturns a spec object.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/spec"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "spec?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L52",
   :line 52,
   :var-type "function",
   :arglists ([x]),
   :doc "returns x if x is a spec object, else logical false",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/spec?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "tuple",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L740",
   :line 740,
   :var-type "macro",
   :arglists ([& preds]),
   :doc
   "takes one or more preds and returns a spec for a tuple, a vector\nwhere each element conforms to the corresponding pred. Each element\nwill be referred to in paths using its ordinal.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/tuple"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "unform",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L247",
   :line 247,
   :var-type "function",
   :arglists ([spec x]),
   :doc
   "Given a spec and a value created by or compliant with a call to\n'conform' with the same spec, returns a value with all conform\ndestructuring undone.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/unform"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "union",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L418",
   :line 418,
   :var-type "macro",
   :arglists ([& schemas]),
   :doc "Takes schemas and unions them, returning a schema object",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/union"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "valid?",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L350",
   :line 350,
   :var-type "function",
   :arglists ([spec x] [spec x settings]),
   :doc "Helper function that returns true when x is valid for spec.",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/valid?"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj",
   :name "with-gen",
   :file "src/main/clojure/clojure/alpha/spec.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/3d32b5e571b98e2930a7b2ed1dd9551bb269375a/src/main/clojure/clojure/alpha/spec.clj#L466",
   :line 466,
   :var-type "macro",
   :arglists ([spec gen-fn]),
   :doc
   "Takes a spec and a no-arg, generator-returning fn and returns a version of that spec that uses that generator",
   :namespace "clojure.alpha.spec",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec/with-gen"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "any",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/any",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/any"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "any-printable",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/any-printable",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/any-printable"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "bind",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/bind",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/bind"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "boolean",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/boolean",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/boolean"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "bytes",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/bytes",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/bytes"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "cat",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L122",
   :line 122,
   :var-type "function",
   :arglists ([& gens]),
   :doc
   "Returns a generator of a sequence catenated from results of\ngens, each of which should generate something sequential.",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/cat"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "char",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/char"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "char-alpha",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char-alpha",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/char-alpha"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "char-alphanumeric",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char-alphanumeric",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/char-alphanumeric"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "char-ascii",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/char-ascii",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/char-ascii"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "choose",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/choose",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/choose"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "delay",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L61",
   :line 61,
   :var-type "macro",
   :arglists ([& body]),
   :doc
   "given body that returns a generator, returns a\ngenerator that delegates to that, but delays\ncreation until used.",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/delay"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "double",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/double",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/double"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "double*",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/double*",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/double*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "elements",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/elements",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/elements"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "fmap",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/fmap",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/fmap"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "for-all*",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L36",
   :line 36,
   :var-type "function",
   :arglists ([& args]),
   :doc "Dynamically loaded clojure.test.check.properties/for-all*.",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/for-all*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "frequency",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/frequency",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/frequency"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "gen-for-name",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L68",
   :line 68,
   :var-type "function",
   :arglists ([s]),
   :doc "Dynamically loads test.check generator named s.",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/gen-for-name"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "gen-for-pred",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L191",
   :line 191,
   :var-type "function",
   :arglists ([pred]),
   :doc
   "Given a predicate, returns a built-in generator if one exists.",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/gen-for-pred"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "generate",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L50",
   :line 50,
   :var-type "function",
   :arglists ([generator]),
   :doc "Generate a single value using generator.",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/generate"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "hash-map",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/hash-map",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/hash-map"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "int",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/int",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/int"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "keyword",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/keyword",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/keyword"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "keyword-ns",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/keyword-ns",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/keyword-ns"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "large-integer",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/large-integer",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/large-integer"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "large-integer*",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/large-integer*",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/large-integer*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "list",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/list",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/list"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "map",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/map",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/map"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "not-empty",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/not-empty",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/not-empty"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "one-of",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/one-of",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/one-of"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "ratio",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/ratio",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/ratio"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "return",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/return",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/return"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "sample",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/sample",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/sample"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "scale",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/scale",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/scale"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "set",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/set",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/set"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "shuffle",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/shuffle",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/shuffle"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "simple-type",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/simple-type",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/simple-type"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "simple-type-printable",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Fn returning clojure.test.check.generators/simple-type-printable",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/simple-type-printable"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "string",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/string",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/string"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "string-alphanumeric",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Fn returning clojure.test.check.generators/string-alphanumeric",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/string-alphanumeric"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "string-ascii",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/string-ascii",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/string-ascii"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "such-that",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/such-that",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/such-that"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "symbol",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/symbol",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/symbol"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "symbol-ns",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/symbol-ns",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/symbol-ns"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "tuple",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/tuple",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/tuple"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "uuid",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L118",
   :line 118,
   :var-type "function",
   :arglists ([& args]),
   :doc "Fn returning clojure.test.check.generators/uuid",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/uuid"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "vector",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc "Lazy loaded version of clojure.test.check.generators/vector",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/vector"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "vector-distinct",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/vector-distinct",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/vector-distinct"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj",
   :name "vector-distinct-by",
   :file "src/main/clojure/clojure/alpha/spec/gen.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/2f84e3a37cab76d44c58785ff4481597429bc1d3/src/main/clojure/clojure/alpha/spec/gen.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([& args]),
   :doc
   "Lazy loaded version of clojure.test.check.generators/vector-distinct-by",
   :namespace "clojure.alpha.spec.gen",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.gen/vector-distinct-by"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/7c708d063b6ea925fd406f87e08f508b7ed8c91d/src/main/clojure/clojure/alpha/spec/protocols.clj",
   :name "Select",
   :file "src/main/clojure/clojure/alpha/spec/protocols.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/7c708d063b6ea925fd406f87e08f508b7ed8c91d/src/main/clojure/clojure/alpha/spec/protocols.clj#L23",
   :line 23,
   :var-type "var",
   :arglists nil,
   :doc "Marker protocol for selects",
   :namespace "clojure.alpha.spec.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.protocols/Select"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/7c708d063b6ea925fd406f87e08f508b7ed8c91d/src/main/clojure/clojure/alpha/spec/protocols.clj",
   :name "Schema",
   :file "src/main/clojure/clojure/alpha/spec/protocols.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/7c708d063b6ea925fd406f87e08f508b7ed8c91d/src/main/clojure/clojure/alpha/spec/protocols.clj#L20",
   :line 20,
   :var-type "protocol",
   :arglists nil,
   :doc nil,
   :namespace "clojure.alpha.spec.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.protocols/Schema"}
  {:raw-source-url nil,
   :name "keyspecs*",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([spec]),
   :doc "Returns map of key to symbolic spec",
   :namespace "clojure.alpha.spec.protocols",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.protocols/keyspecs*"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "abbrev-result",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L556",
   :line 556,
   :var-type "function",
   :arglists ([x]),
   :doc
   "Given a check result, returns an abbreviated version\nsuitable for summary use.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/abbrev-result"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "check",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L490",
   :line 490,
   :var-type "function",
   :arglists ([] [sym-or-syms] [sym-or-syms opts]),
   :doc
   "Run generative tests for spec conformance on vars named by\nsym-or-syms, a symbol or collection of symbols. If sym-or-syms\nis not specified, check all checkable vars.\n\nThe opts map includes the following optional keys, where stc\naliases clojure.spec.test.check: \n\n::stc/opts  opts to flow through test.check/quick-check\n:gen        map from spec names to generator overrides\n\nThe ::stc/opts include :num-tests in addition to the keys\ndocumented by test.check. Generator overrides are passed to\nspec/gen when generating function args.\n\nReturns a lazy sequence of check result maps with the following\nkeys\n\n:spec       the spec tested\n:sym        optional symbol naming the var tested\n:failure    optional test failure\n::stc/ret   optional value returned by test.check/quick-check\n\nThe value for :failure can be any exception. Exceptions thrown by\nspec itself will have an ::s/failure value in ex-data:\n\n:check-failed   at least one checked return did not conform\n:no-args-spec   no :args spec provided\n:no-fn          no fn provided\n:no-fspec       no fspec provided\n:no-gen         unable to generate :args\n:instrument     invalid args detected by instrument",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/check"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "check-fn",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L473",
   :line 473,
   :var-type "function",
   :arglists ([f spec] [f spec opts]),
   :doc
   "Runs generative tests for fn f using spec and opts. See\n'check' for options and return.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/check-fn"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "checkable-syms",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L481",
   :line 481,
   :var-type "function",
   :arglists ([] [opts]),
   :doc
   "Given an opts map as per check, returns the set of syms that\ncan be checked.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/checkable-syms"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "enumerate-namespace",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L41",
   :line 41,
   :var-type "function",
   :arglists ([ns-sym-or-syms]),
   :doc
   "Given a symbol naming an ns, or a collection of such symbols,\nreturns the set of all symbols naming vars in those nses.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/enumerate-namespace"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "instrument",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L322",
   :line 322,
   :var-type "function",
   :arglists ([] [sym-or-syms] [sym-or-syms opts]),
   :doc
   "Instruments the vars named by sym-or-syms, a symbol or collection\nof symbols, or all instrumentable vars if sym-or-syms is not\nspecified.\n\nIf a var has an :args fn-spec, sets the var's root binding to a\nfn that checks arg conformance (throwing an exception on failure)\nbefore delegating to the original fn.\n\nThe opts map can be used to override registered specs, and/or to\nreplace fn implementations entirely. Opts for symbols not included\nin sym-or-syms are ignored. This facilitates sharing a common\noptions map across many different calls to instrument.\n\nThe opts map may have the following keys:\n\n  :spec     a map from var-name symbols to override specs\n  :stub     a set of var-name symbols to be replaced by stubs\n  :gen      a map from spec names to generator overrides\n  :replace  a map from var-name symbols to replacement fns\n\n:spec overrides registered fn-specs with specs your provide. Use\n:spec overrides to provide specs for libraries that do not have\nthem, or to constrain your own use of a fn to a subset of its\nspec'ed contract.\n\n:stub replaces a fn with a stub that checks :args, then uses the\n:ret spec to generate a return value.\n\n:gen overrides are used only for :stub generation.\n\n:replace replaces a fn with a fn that checks args conformance, then\ninvokes the fn you provide, enabling arbitrary stubbing and mocking.\n\n:spec can be used in combination with :stub or :replace.\n\nReturns a collection of syms naming the vars instrumented.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/instrument"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "instrumentable-syms",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L311",
   :line 311,
   :var-type "function",
   :arglists ([] [opts]),
   :doc
   "Given an opts map as per instrument, returns the set of syms\nthat can be instrumented.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/instrumentable-syms"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "summarize-results",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L566",
   :line 566,
   :var-type "function",
   :arglists ([check-results] [check-results summary-result]),
   :doc
   "Given a collection of check-results, e.g. from 'check', pretty\nprints the summary-result (default abbrev-result) of each.\n\nReturns a map with :total, the total number of results, plus a\nkey with a count for each different :type of result.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/summarize-results"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "unstrument",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L371",
   :line 371,
   :var-type "function",
   :arglists ([] [sym-or-syms]),
   :doc
   "Undoes instrument on the vars named by sym-or-syms, specified\nas in instrument. With no args, unstruments all instrumented vars.\nReturns a collection of syms naming the vars unstrumented.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/unstrument"}
  {:raw-source-url
   "https://github.com/clojure/spec-alpha2/raw/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj",
   :name "with-instrument-disabled",
   :file "src/main/clojure/clojure/alpha/spec/test.clj",
   :source-url
   "https://github.com/clojure/spec-alpha2/blob/72ce4f20d683ac74b9704fa9870f5e6301b295e6/src/main/clojure/clojure/alpha/spec/test.clj#L65",
   :line 65,
   :var-type "macro",
   :arglists ([& body]),
   :doc "Disables instrument's checking of calls, within a scope.",
   :namespace "clojure.alpha.spec.test",
   :wiki-url
   "https://clojure.github.io/spec-alpha2//index.html#clojure.alpha.spec.test/with-instrument-disabled"})}
