;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.spec-alpha2.protocols)

(defprotocol Spec
  :extend-via-metadata true
  (conform* [spec x])
  (unform* [spec y])
  (explain* [spec path via in x])
  (gen* [spec overrides path rmap])
  (with-gen* [spec gfn])
  (describe* [spec]))

(defprotocol Schema
  (keyspecs* [spec] "Returns map of key to symbolic spec"))

(defprotocol Select
  "Marker protocol for selects")

(defprotocol Closable
  "A spec that can conform with closed semantics"
  (close* [spec] "Returns a Closed version of this spec"))

(defprotocol Closed
  "Protocol for specs that conform with closed semantics"
  (conform-closed* [spec x])
  (explain-closed* [spec path via in x])
  (open* [spec]))

