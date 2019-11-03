(ns projects.bestfirst)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn best-firstSearch
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
       (best-firstSearch state goal lmg map [] [])))

  ([state goal lmg map been finalRoute]
   (cond
     (= (:state state) goal )
        (sort-by :cost (into [] (set(conj finalRoute state))))

     (empty? (removeBeenValues (lmg map state) been))
         (best-firstSearch
           {:state (:state (last finalRoute)) :cost (- (state :cost) (fixPrice map (:state state) (:state (last finalRoute))))}
           goal
           lmg
           map
           (conj been (:state state))
           (into [] (butlast finalRoute)))

     (= (count (set been)) (allLocations map))
       false

     :else
         (best-firstSearch
           (first (sort-by :cost (removeBeenValues (lmg map state) been)))
           goal
           lmg
           map
           (conj been (:state state))
           (conj finalRoute state)))))

;;(best-firstSearch {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (best-firstSearch {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))

