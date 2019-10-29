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

(defn removeBeenValues [states toRemove]
  "after using the legal move generator
  you can pass the result to this function
  to remove stations you have already visited."
  (remove nil? (for [ {state :state cos :cost} states] (if (some #(= state %)toRemove) nil (hash-map :cost cos :state state)))))

(defn dijkstra
  ([state goal lmg]
   (dijkstra state goal lmg []))
  ([state goal lmg visited]
   (cond
     (= (:state state) goal) (do (println state "- FOUND IT M8") state)
     (empty? (removeBeenValues (lmgB state) visited)) (do (println state "- no options") false)
     :else
        (do (println state) (for [currentState (removeBeenValues (sort-by :cost (lmg state)) visited)] (dijkstra currentState goal lmg (conj visited (:state currentState))))
     ))))

