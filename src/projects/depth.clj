(ns projects.depth)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn depth-firstSearch
  "you can use this function to find a cheap route
  between two locations through many locations
  with different possible costs - using the best first search algorithm"
  ([state goal lmg map]
   (depth-firstSearch state goal lmg map []))
  ([state goal lmg map been]
   (cond
     (= (:state state) goal )
     (do (conj been (:state state)) state)
     (= (count (set been)) (allStations map))
     false
     (empty? (removeBeenValues (lmg map state) been))
     (do (println state " - FAIL")
         (depth-firstSearch {:state (last been) :cost (- (state :cost) (fixPrice map (:state state) (last been)))} goal lmg map (conj been (:state state))))
     :else
     (do (println state)
         (depth-firstSearch (first (removeBeenValues (lmg map state) been)) goal lmg map (conj been (:state state)))))))

;;(depth-firstSearch {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (depth-firstSearch {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))