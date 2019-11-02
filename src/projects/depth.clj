(ns projects.depth)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn depth-firstSearch
  "to be written"
  ([state goal lmg map]
   (if
     (not (containsLocation map goal))
     (str "location not valid")
     (depth-firstSearch state goal lmg map [] [])))

  ([state goal lmg map been finalRoute]
   (cond
     (= (:state state) goal )
       (sort-by :cost (into [] (set(conj finalRoute state))))

     (= (count (set been)) (allStations map))
        false

     (empty? (removeBeenValues (lmg map state) been))
         (depth-firstSearch
           {:state (last been) :cost (- (state :cost) (fixPrice map (:state state) (last been)))}
           goal
           lmg
           map
           (conj been (:state state))
           finalRoute)

     :else
         (depth-firstSearch
           (first (removeBeenValues (lmg map state) been))
           goal
           lmg
           map
           (conj been (:state state))
           (conj finalRoute state)))))


;;(depth-firstSearch {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (depth-firstSearch {:state "newcastle" :cost 0} "chester" bestFirstLMG busRoutes00))