(ns footpad.core)


(defn generate-room [width height]
  ;; The smallest possible room is 3 x 3 -- with no stairs
  (if (and (>= width 3) (>= height 3))
    (let [staircase (inc (rand-int (- width 2)))] )))

(defn generate-rock [width height]
  (repeatedly height #(take width (cycle [\#]))))

(defn insert-stairs [row width]
  (let [x (inc (rand-int (- width 2)))
        [left right] (split-at x row)]
    (concat left [\>] (rest right))))

(defn generate-rock-with-stairs [room width height]
  (let [y (inc (rand-int (- height 2)))
        [top bottom] (split-at y room)
        to-change (first bottom)]
    (concat top [(insert-stairs to-change width)] (rest bottom))))