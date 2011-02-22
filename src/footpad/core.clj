(ns footpad.core)


(defn generate-room [width height]
  ;; The smallest possible room is 3 x 3 -- with no stairs
  (if (and (>= width 3) (>= height 3))
    (let [staircase (inc (rand-int (- width 2)))] )))

(defn generate-rock [width height]
  (repeatedly height #(take width (cycle [\#]))))
