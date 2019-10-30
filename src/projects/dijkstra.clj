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
   ;; (findCheapestVec(dijkstra state goal lmg map [] []))
   (dijkstra state goal lmg map [] 10000000 []))

  ([state goal lmg map bestRoute score visited]
   (cond
     (< score (:cost state))
     (do (println state "this way is pointless, score: " score ) false)

     (= (:state state) goal)
     (do
       (println state "- FOUND IT M8")
       (hash-map :route (conj bestRoute state)))

     (empty? (removeBeenValues (lmg map state) visited))
       false

     :else
       (do
         (println state)
         (flatten
           (remove false?
               (for [currentState (removeBeenValues (sort-by :cost (lmg map state)) visited) ]
                  (dijkstra
                   currentState
                   goal
                   lmg
                   map
                   (conj bestRoute state)
                   score
                   (conj visited (:state currentState))))))))))

;; (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;; (time (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))