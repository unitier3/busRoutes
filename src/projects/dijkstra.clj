(ns projects.dijkstra)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn dijkstra
  "you can use this function to find a cheap route
  between two locations through many locations
  with different possible costs - using the best first search algorithm"

  ([state goal lmg map]
   (cond
     (not (containsLocation map goal))
     (str goal " is not a valid destination")

     (not (containsStation map (:state state)))
     (str (:state state) " is not a start location")

     :else
       (findCheapestVec
         (dijkstra state goal lmg map (dijkstra state goal lmg map [] []) [] []))))

  ([state goal lmg map been currentBest]
   (cond
     (= (:state state) goal )
       (sort-by :cost (into [] (set (conj currentBest state))))

     (empty? (removeBeenValues (lmg map state) been))
       (dijkstra
         {:state (:state (last currentBest)) :cost (- (state :cost) (fixPrice map (:state state) (:state (last currentBest))))}
         goal
         lmg
         map
         (conj been (:state state))
         (into [] (butlast currentBest)))

     (= (count (set been)) (allLocations map))
       false

     :else
       (dijkstra
         (first (sort-by :cost (removeBeenValues (lmg map state) been)))
         goal
         lmg
         map
         (conj been (:state state))
         (conj currentBest state))))

  ([state goal lmg map toBeat Routes visited]
   (cond
     (= (:state state) goal)
       (hash-map :route (conj Routes state))

     (empty? (removeBeenValues (lmg map state) visited))
       false

     (> (:cost state) (:cost (last toBeat)))
       false

     :else
     (flatten
       (remove false?
               (for [currentState (removeBeenValues (lmg map state) visited)]
                 (dijkstra
                   currentState
                   goal
                   lmg
                   map
                   toBeat
                   (conj Routes state)
                   (conj visited (:state currentState)))))))))

;; (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;; (time (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))