(ns projects.dijkstra)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn dijkstra
  ([state goal lmg map]
   (dijkstra state goal lmg map []))
  ([state goal lmg map visited]
   (cond
     (= (:state state) goal) (do (println state "- FOUND IT M8") state)
     (empty? (removeBeenValues (lmg map state) visited)) (do (println state "- no options") false)
     :else
        (do (println state) (for [currentState (removeBeenValues (sort-by :cost (lmg map state)) visited)] (dijkstra currentState goal lmg map (conj visited (:state currentState))))
     ))))

;; (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)

;; (time (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))