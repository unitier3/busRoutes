(ns projects.brute)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn brute
  ([state goal lmg map]
   (brute state goal lmg map [] []))
  ([state goal lmg map bestRoute visited]
   (cond
     (= (:state state) goal)
     (do
       (println state "- FOUND IT M8")
       (hash-map :route (conj bestRoute state)))
     (empty? (removeBeenValues (lmg map state) visited))
     false
     :else
     (flatten (remove false? (identity (for [currentState (removeBeenValues (sort-by :cost (lmg map state)) visited)]
                                         (brute currentState goal lmg map (conj bestRoute state) (conj visited (:state currentState))))))))))



;; (brute {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;; (time (brute {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))