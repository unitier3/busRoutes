(ns projects.dijkstra)

(use '[imports.matcher :refer :all])
(use '[imports.trace :refer :all])
(use '[imports.ops_search :refer :all])
(use '[imports.a-star-search :refer :all])
(use '[imports.breadth-search :refer :all])

(def busRoutes2
'{ :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
  :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
  })

(defn lmgB [state]
  (let [location (:state state)
        cost (:cost state)]
    (for [{loc :location cos :cost} (busRoutes2 (keyword location))]  (hash-map :cost (+ cos cost) :state loc))))

(defn allStations []
  "calling this function returns
  the count of all stations which can be visited."
  (count (set (flatten (for [x busRoutes2] (for [{loc :location cos :cost} (second x) ] loc))))))

(defn dijkstra [state goal lmg]
  (cond
    (= (state :loc) goal) true
    :else false
    ))
