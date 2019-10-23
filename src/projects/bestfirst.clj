(ns projects.bestfirst)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(def busRoutes
  '{ :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
    :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})
    :durham ({:location "darlington" :cost 3} {:location "newcastle" :cost 6})
    :northallerton ({:location "durham" :cost 4} {:location "darlington" :cost 5})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "bolton" :cost 4})
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    })

(defn bestFirstLMG [state]
  "this function returns all possible routes that the user/machine can take from its current location."
  (let [location (:state state)
        cost (:cost state)]
    (for [{loc :location cos :cost} (busRoutes (keyword location))]  (hash-map :cost (+ cos cost) :state loc))))

(defn allStations []
  "calling this function returns
  the count of all stations which can be visited."
  (count (set (flatten (for [x busRoutes] (for [{loc :location cos :cost} (second x) ] loc))))))

(defn removeBeenValues [states toRemove]
  "after using the legal move generator
  you can pass the result to this function
  to remove stations you have already visited."
  (remove nil? (for [ {state :state cos :cost} states] (if (some #(= state %)toRemove) nil (hash-map :cost cos :state state)))))

(defn fixPrice [currentLoc previousLoc]
  "this function is used to update the
  price if we have to back track to a previous
  location we have already visited."
  (first (remove nil? (for [{loc :location cost :cost} (busRoutes (keyword previousLoc))] (if (= loc currentLoc) cost )))))

(defn best-firstSearchA
  "you can use this function to find a cheap route
  between two locations through many locations
  with different possible costs - using the best first search algorithm"
  ([state goal lmg]
   (best-firstSearchA state goal lmg []))
  ([state goal lmg been]
   (cond
     (= (:state state) goal )
         (do (conj been (:state state)) state)
     (= (count been) allStations)
         false
     (empty? (removeBeenValues (lmg state) been))
         (do (println state " - FAIL")
             (best-firstSearchA {:state (last been) :cost (- (state :cost) (fixPrice (:state state) (last been)))} goal lmg (conj been (:state state))))
     :else
     (do (println state)
         (best-firstSearchA (first (sort-by :cost (removeBeenValues (lmg state) been))) goal lmg (conj been (:state state)))))))

;;(best-firstSearchA {:state "newcastle" :cost 0} "chester" bestFirstLMG)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (best-firstSearchA {:state "newcastle" :cost 0} "chester" bestFirstLMG))

(defn best-firstSearchB
  "this function is an attempt to improve the previous function
  with the help of the 'or' function, it does return a current result
  but still has some issues yet to be resolved."
  ([state goal lmg]
   (best-firstSearchB state goal lmg []))
  ([state goal lmg been]
   (cond
     (= (:state state) goal )
     (do (conj been (:state state)) state)
     (= (count been) allStations) false
     (empty? (removeBeenValues (lmg state) been)) false
     :else
     (do (println state)
         (or
           (for [x [(sort-by :cost (removeBeenValues (lmg state) been))]] (best-firstSearchB x goal lmg (conj been (:state state)))) )))))

;;(best-firstSearchB {:state "newcastle" :cost 0} "chester" bestFirstLMG)
;;Find out Elapsed time for best-firstSearchB to run:
;;(time (best-firstSearchB {:state "newcastle" :cost 0} "chester" bestFirstLMG))