spec-alpha2
========================================

spec is a Clojure library to describe the structure of data and functions. Specs can be used to validate data, conform (destructure) data, explain invalid data, generate examples that conform to the specs, and automatically use generative testing to test functions.

For more information:

* Rationale - https://clojure.org/about/spec
* Guide - https://clojure.org/guides/spec (for spec.alpha, note namespaces and other differences below)

spec.alpha was released with Clojure 1.9 and can be found at https://github.com/clojure/spec.alpha. spec-alpha2 incorporates feedback from spec.alpha as well as work towards several new features. Please note that spec-alpha2 is not 100% API-compatible with spec.alpha (although it is similar).

Namespaces to load:

    (require '[clojure.spec-alpha2 :as s]
             '[clojure.spec-alpha2.gen :as gen]
             '[clojure.spec-alpha2.test :as test])

Also see: [Differences from spec.alpha](https://github.com/clojure/spec-alpha2/wiki/Differences-from-spec.alpha)


Releases and Dependency Information
========================================

Development release:

During development, you can use the git dep to try spec-alpha2:

    clj -Sdeps '{:deps {org.clojure/clojure {:mvn/version "1.10.0"}
                        org.clojure/test.check {:mvn/version "0.9.0"} 
                        org.clojure/spec-alpha2 {:git/url "https://github.com/clojure/spec-alpha2.git" 
                                                 :sha "<SHA>"}}}'

Where the latest SHA can be found with:

    git ls-remote https://github.com/clojure/spec-alpha2.git refs/heads/master


Latest stable release: TBD

* [All Released Versions](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.clojure%22%20AND%20a%3A%22spec-alpha2%22)
* [Development Snapshot Versions](https://oss.sonatype.org/index.html#nexus-search;gav~org.clojure~spec-alpha2~~~)

[deps.edn](https://clojure.org/guides/deps_and_cli) dependency information:

    org.clojure/spec-alpha2 {:mvn/version "TBD"}

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

    [org.clojure/spec-alpha2 "TBD"]

[Maven](http://maven.apache.org/) dependency information:

    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>spec-alpha2</artifactId>
      <version>TBD</version>
    </dependency>

Developer Information
========================================

* [API docs](http://clojure.github.io/spec-alpha2/)
* [GitHub project](https://github.com/clojure/spec-alpha2)
* [Changelog](https://github.com/clojure/spec-alpha2/blob/master/CHANGES.md)
* [Bug Tracker](http://dev.clojure.org/jira/browse/CLJ)
* [Continuous Integration](http://build.clojure.org/job/spec-alpha2/)
* [Compatibility Test Matrix](http://build.clojure.org/job/spec-alpha2-test-matrix/)

Copyright and License
========================================

Copyright (c) Rich Hickey, and contributors, 2018. All rights reserved.  The use and distribution terms for this software are covered by the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) which can be found in the file epl-v10.html at the root of this distribution. By using this software in any fashion, you are agreeing to be bound bythe terms of this license.  You must not remove this notice, or any other, from this software.
