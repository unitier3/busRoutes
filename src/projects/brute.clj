(ns projects.brute)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn brute
  ([state goal map]
   (cond
     (not (containsLocation map goal))
       (str goal " is not a valid destination")

     (not (containsStation map (:state state)))
       (str (:state state) " is not a start location")

     :else
       (findCheapestVec(brute state goal map [] [])))
   )

  ([state goal map bestRoute visited]
   (cond
     (= (:state state) goal)
       (hash-map :route (conj bestRoute state))

     (empty? (removeBeenValues (LMG map state) visited))
       false

     :else
       (flatten
         (remove false?
           (for [currentState (removeBeenValues (LMG map state) visited)]
             (brute
               currentState
               goal
               map
               (conj bestRoute state)
               (conj visited (:state currentState)))))))))


;; (brute {:state "newcastle" :cost 0} "chester" busRoutes00)
;; (time (brute {:state "newcastle" :cost 0} "chester" busRoutes00))