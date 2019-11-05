(ns projects.astar)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(defn A*lmg [state]
  (let [location (:state state)
        cost (:cost state)]
    (for [{loc :location cos :cost} (busRoutes15 (keyword location))]  (hash-map :cost (+ cos cost) :state loc))))


;;(A*search {:state "newcastle" :cost 0} "chester" A*lmg)
;;Find out Elapsed time for A*search to run:
;;(time (A*search {:state "newcastle" :cost 0} "chester" A*lmg))



