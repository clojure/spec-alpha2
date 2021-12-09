;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.test-clojure.multi-spec
  (:require [clojure.spec.alpha :as s]
            [clojure.test :as test :refer [deftest is testing]]
            [clojure.test-clojure.spec :refer [submap?]]))

(s/def :event/type keyword?)
(s/def :event/timestamp int?)
(s/def :search/url string?)
(s/def :error/message string?)
(s/def :error/code int?)

(defmulti event-type :event/type)
(defmethod event-type :event/search [_]
  (s/keys :req [:event/type :event/timestamp :search/url]))
(defmethod event-type :event/error [_]
  (s/keys :req [:event/type :event/timestamp :error/message :error/code]))

(s/def :event/event (s/multi-spec event-type :event/type))

(deftest multi-spec-test
  (is (s/valid? :event/event
        {:event/type :event/search
         :event/timestamp 1463970123000
         :search/url "https://clojure.org"}))
  (is (s/valid? :event/event
        {:event/type :event/error
         :event/timestamp 1463970123000
         :error/message "Invalid host"
         :error/code 500}))
  (is (submap?
        '#:clojure.spec.alpha{:problems
                              [{:path [:event/restart],
                                :pred clojure.test-clojure.multi-spec/event-type,
                                :val #:event{:type :event/restart}, :reason "no method", :via [:event/event], :in []}],
                              :spec :event/event, :value #:event{:type :event/restart}}
        (s/explain-data :event/event
          {:event/type :event/restart})))
  (is (submap?
        '#:clojure.spec.alpha{:problems ({:path [:event/search],
                                          :pred (clojure.core/fn [%] (clojure.core/contains? % :event/timestamp)),
                                          :val {:event/type :event/search, :search/url 200},
                                          :via [:event/event], :in []} {:path [:event/search :search/url],
                                                                        :pred clojure.core/string?, :val 200,
                                                                        :via [:event/event :search/url],
                                                                        :in [:search/url]}), :spec
                              :event/event, :value {:event/type :event/search, :search/url 200}}
        (s/explain-data  :event/event
          {:event/type :event/search
           :search/url 200}))))