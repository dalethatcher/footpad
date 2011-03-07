(ns footpad.generate)

(defstruct point :xloc :type)

;; Make it easier to refer to the types of characters
;; that we deal with.
(def game-chars {:rock \#
                 :up   \>
                 :down \<
                 :space \space})

(defn print-out [ p ]
  ((:type p) game-chars))

(defn pad-spaces [amount]
  (take amount (repeat (:space game-chars))))

(defn add-point [coll p]
  (concat
   coll
   (pad-spaces (- (:xloc p) (count coll)))
   (list ((:type p) game-chars))))

(defn to-points [ coll ]
  (if (zero? (mod (count coll) 2))
    (map #(apply struct point %1 ) (partition 2 coll))))

;; (defn full-wall [ s ]
;;   (map #(struct point % :rock) (range 0 s)))

(defn print-game-line [ coll ]
  (String. (char-array (reduce add-point () (to-points coll)))))
