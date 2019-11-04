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
  ([state goal map]
   (cond
     (not (containsLocation map goal))
       (str goal " is not a valid destination")

     (not (containsStation map (:state state)))
       (str (:state state) " is not a start location")

     :else
       (depth-firstSearch state goal map [] [])))

  ([state goal map been finalRoute]
   (cond
     (= (:state state) goal )
       (sort-by :cost (into [] (set(conj finalRoute state))))

     (= (count (set been)) (allLocations map))
        false

     (empty? (removeBeenValues (LMG map state) been))
         (depth-firstSearch
           {:state (:state (last finalRoute)) :cost (- (state :cost) (fixPrice map (:state state) (:state (last finalRoute))))}
           goal
           map
           (conj been (:state state))
           (into [] (butlast finalRoute)))

     :else
         (depth-firstSearch
           (first (removeBeenValues (LMG map state) been))
           goal
           map
           (conj been (:state state))
           (conj finalRoute state)))))


;;(depth-firstSearch {:state "newcastle" :cost 0} "chester" busRoutes00)
;;Find out Elapsed time for best-firstSearchA to run:
;;(time (depth-firstSearch {:state "newcastle" :cost 0} "chester" busRoutes00))