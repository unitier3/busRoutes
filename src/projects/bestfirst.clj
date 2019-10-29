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
   (best-firstSearchA state goal lmg map []))
  ([state goal lmg map been]
   (cond
     (= (:state state) goal )
         (do (conj been (:state state)) state)
     (= (count (set been)) (allStations map))
         false
     (empty? (removeBeenValues (lmg map state) been))
         (do (println state " - FAIL")
             (best-firstSearchA {:state (last been) :cost (- (state :cost) (fixPrice map (:state state) (last been)))} goal lmg map (conj been (:state state))))
     :else
     (do (println state)
         (best-firstSearchA (first (sort-by :cost (removeBeenValues (lmg map state) been))) goal lmg map (conj been (:state state)))))))

;;(best-firstSearchA {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (best-firstSearchA {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))

(defn best-firstSearchB
  "this function is an attempt to improve the previous function
  with the help of the 'or' function, it does return a current result
  but still has some issues yet to be resolved."
  ([state goal lmg map]
   (best-firstSearchB state goal lmg map []))
  ([state goal lmg map been]
   (cond
     (= (:state state) goal )
     (do (conj been (:state state)) state)
     (= (count (set been)) (allStations map) ) false
     (empty? (removeBeenValues (lmg map state) been)) false
     :else
     (do (println state)
         (or
           (flatten (for [x (sort-by :cost (removeBeenValues (lmg map state) been))] (best-firstSearchB x goal lmg map (conj been (:state state))))))))))

;;(best-firstSearchB {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;;Find out Elapsed time for best-firstSearchB to run:
;;(time (best-firstSearchB {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))