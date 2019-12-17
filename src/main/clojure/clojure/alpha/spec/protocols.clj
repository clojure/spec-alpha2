;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.alpha.spec.protocols)

(defprotocol Spec
  :extend-via-metadata true
  (conform* [spec x settings-key settings])
  (unform* [spec y])
  (explain* [spec path via in x settings-key settings])
  (gen* [spec overrides path rmap])
  (with-gen* [spec gfn])
  (describe* [spec]))

(defprotocol Schema
  (keyspecs* [spec] "Returns map of key to symbolic spec"))

(defprotocol Select
  "Marker protocol for selects")

