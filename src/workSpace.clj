(ns workSpace)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(use '[projects.helperFunctions :refer :all])
(use '[projects.scenarios :refer :all])

(use '[projects.astar :refer :all])
(use '[projects.bestfirst :refer :all])
(use '[projects.brute :refer :all])
(use '[projects.depth :refer :all])
(use '[projects.dijkstra :refer :all])

;;(A*search {:state "newcastle" :cost 0} "chester" A*lmg)
;;(time (A*search {:state "newcastle" :cost 0} "chester" A*lmg))

;;(best-firstSearch {:state "newcastle" :cost 0} "chester" busRoutes01)
;;(time (best-firstSearch {:state "newcastle" :cost 0} "chester" busRoutes01))

;; (brute {:state "newcastle" :cost 0} "chester" busRoutes01)
;; (time (brute {:state "newcastle" :cost 0} "chester" busRoutes01))

;;(depth-firstSearch {:state "newcastle" :cost 0} "chester" busRoutes01)
;;(time (depth-firstSearch {:state "newcastle" :cost 0} "chester" busRoutes01))

;; (dijkstra {:state "newcastle" :cost 0} "chester" busRoutes01)
;; (time (dijkstra {:state "newcastle" :cost 0} "chester" busRoutes01))