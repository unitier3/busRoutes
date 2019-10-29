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
   (dijkstra state (:state state) goal lmg map [] [] []))
  ([state start goal lmg map been currentRoute bestRoute]
   (cond
     (= (:state state) goal)
       (sort-by :cost currentRoute)
     (= (count (set been)) (allStations map))
       false
     (empty? (removeBeenValues (lmg map state) been))
       (do
         (println state " - FAIL")
         (dijkstra
           {:state (last been) :cost (- (state :cost) (fixPrice map (:state state) (last been)))}
           start goal lmg map
           (conj been (:state state))
           currentRoute
           bestRoute))
     :else
       (do
         (println state)
         (dijkstra
           (first (sort-by :cost (removeBeenValues (lmg map state) been)))
           start goal lmg map
           (conj been (:state state))
           (conj (into [] (set currentRoute)) state)
           bestRoute)))))

;; (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;; (time (dijkstra {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))