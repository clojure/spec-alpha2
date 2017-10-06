# Change Log for spec.alpha

## Version 0.1.134 on Oct 6, 2017

* [CLJ-2103](https://dev.clojure.org/jira/browse/CLJ-2103) - s/coll-of and s/every gen is very slow if :kind specified without :into
* [CLJ-2171](https://dev.clojure.org/jira/browse/CLJ-2171) - Default explain printer shouldn't print root val and spec
* Mark Clojure dependency as a provided dep so it's not transitively included

## Version 0.1.123 on May 26, 2017

* No changes, just a rebuild

## Version 0.1.109 on May 26, 2017

* [CLJ-2153](https://dev.clojure.org/jira/browse/CLJ-2153) - Docstring for int-in-range? and int-in now mention fixed precision constraint
* [CLJ-2085](https://dev.clojure.org/jira/browse/CLJ-2085) - Add the top level spec and value to explain-data
* [CLJ-2076](https://dev.clojure.org/jira/browse/CLJ-2076) - coll-of and map-of should unform their elements
* [CLJ-2063](https://dev.clojure.org/jira/browse/CLJ-2063) - report explain errors in order from longest to shortest path
* [CLJ-2061](https://dev.clojure.org/jira/browse/CLJ-2061) - Better error message when exercise-fn called on fn without :args spec
* [CLJ-2059](https://dev.clojure.org/jira/browse/CLJ-2059) - explain-data should return resolved preds
* [CLJ-2057](https://dev.clojure.org/jira/browse/CLJ-2057) - If :ret spec is not supplied, use any?

## Version 0.1.108 on May 2, 2017

* AOT compile the spec namespaces

## Version 0.1.94 on Apr 26, 2017

* Moved spec namespaces from Clojure
* Renamed spec namespaces to append ".alpha"

