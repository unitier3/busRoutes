(ns projects.bestfirst)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn best-firstSearchA
  "you can use this function to find a cheap route
  between two locations through many locations
  with different possible costs - using the best first search algorithm"
  ([state goal lmg map]
   (best-firstSearchA state goal lmg map [] []))

  ([state goal lmg map been finalRoute]
   (cond
     (not (containsLocation map goal))
       (str "this map does not contain that location")

     (= (:state state) goal )
        (sort-by :cost (into [] (set(conj finalRoute state))))

     (= (count (set been)) (allStations map))
        false

     (empty? (removeBeenValues (lmg map state) been))
         (best-firstSearchA
           {:state (last been) :cost (- (state :cost) (fixPrice map (:state state) (last been)))}
           goal
           lmg
           map
           (conj been (:state state))
           finalRoute)

     :else
         (best-firstSearchA
           (first (sort-by :cost (removeBeenValues (lmg map state) been)))
           goal
           lmg
           map
           (conj been (:state state))
           (conj finalRoute state) ))))

;;(best-firstSearchA {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (best-firstSearchA {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))

