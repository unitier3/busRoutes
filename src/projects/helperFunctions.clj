(ns projects.helperFunctions)

(defn bestFirstLMG [map state]
  "this function returns all possible routes that the user/machine can take from its current location."
  (let [location (:state state)
        cost (:cost state)]
    (for [{loc :location cos :cost} (map (keyword location))]  (hash-map :cost (+ cos cost) :state loc))))

(defn allStations [map]
  "calling this function returns
  the count of all stations which can be visited."
  (count (set (flatten (for [x map] (for [{loc :location cos :cost} (second x) ] loc))))))

(defn removeBeenValues [states toRemove]
  "after using the legal move generator
  you can pass the result to this function
  to remove stations you have already visited."
  (remove nil? (for [ {state :state cos :cost} states] (if (some #(= state %)toRemove) nil (hash-map :cost cos :state state)))))

(defn fixPrice [map currentLoc previousLoc]
  "this function is used to update the
  price if we have to back track to a previous
  location we have already visited."
  (first (remove nil? (for [{loc :location cost :cost} (map (keyword previousLoc))] (if (= loc currentLoc) cost )))))

(defn findCheapestVec [lis]
  (reduce (fn [a b] (if (<(:cost (last a)) (:cost (last b))) a b )) (for [ {route :route } lis]  route)))

(defn containsLocation [map location]
  (contains? (set (flatten (for [x map] (for [{loc :location cos :cost} (second x) ] loc)))) location))