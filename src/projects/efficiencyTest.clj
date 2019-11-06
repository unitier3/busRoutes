(ns projects.efficiencyTest)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])


(defn efficient?_
  ([state goal map]
   (cond
     (not (containsLocation map goal))
     (str goal " is not a valid destination")

     (not (containsStation map (:state state)))
     (str (:state state) " is not a start location")

     :else
      (reverse  (sort #(compare (:cost(last (:route %1))) (:cost(last(:route %2))) )(efficient?_ state goal map [] []))))
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
                 (efficient?_
                   currentState
                   goal
                   map
                   (conj bestRoute state)
                   (conj visited (:state currentState)))))))))

(defn percent? [solution possibleSolutions score outOf]
    (if
    (= solution (first possibleSolutions))
    (/ score outOf)
    (percent? solution (rest possibleSolutions) (+ score 1) outOf)
    ))

(defn efficient? [solution state goal map]
  (percent? (hash-map :route solution) (efficient?_ state  goal map) 1 (count (efficient?_ state  goal map))))


;; (efficient? "solution" {:state "newcastle" :cost 0} "chester" busRoutes00)