(ns footpad.generate-test
  (:use footpad.generate
        clojure.test :reload))


(deftest padding
  (testing "Zero padding"
    (= () (pad-spaces 0)))
  (testing "Other cases"
    (= (list \space) (pad-spaces 1))
    (= (list \space \space) (pad-spaces 2))))

(deftest adding
  (testing "Simple case"
    (= (list \#) (add-point () (struct point 0 :rock)))
    )
  (testing "Padded case"
    (= (list \space \space \#) (add-point () (struct point 2 :rock))))
  (testing "Pre-populated list"
    (= (list \# \space \space \space \>) (add-point (list \#) (struct point 4 :up))))
  )

(deftest converting
  (testing "Simple case"
    (= (list (struct point 2 :rock) (struct point 6 :up))
       (to-points [2 :rock 6 :up]))))
