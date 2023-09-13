(ns clojure.test-clojure.perf
  (:require
    [clojure.string :as str]
    [clojure.alpha.spec :as s]
    [clojure.alpha.spec.gen :as gen]))

(s/def ::a int?)
(s/def ::b keyword?)
(s/def ::attribute (s/schema {:a ::a
                              :b ::b}))

(defn id? [s] (str/starts-with? s "I"))
(s/def ::id (s/with-gen (s/and string? id?)
              (fn [] (gen/fmap #(str "I" %) (s/gen (s/spec int?))))))
(s/def ::first string?)
(s/def ::last string?)
(s/def ::user (s/schema {:first ::first
                         :last ::last
                         :id ::id
                         :attributes (s/coll-of ::attribute)}))

(s/def ::user1
  (s/select ::user
    [:attributes {:attributes [:a :b]}
     :first
     :last]))

;; make 100x100 samples - restarting to avoid getting too complex
(def samples
  (mapcat
    (fn [_] (gen/sample (s/gen ::user1) 100))
    (range 100)))

;; perf test
(defn perf
  [reps f]
  (dotimes [_ reps]
    (time
      (run! #(f ::user1 %) samples))))

(comment
  (take 10 samples)

  (perf 5 s/valid?)
  (perf 5 s/explain-data)

  )