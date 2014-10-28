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
    (= (list \#) (add-point () (struct point :rock 0)))
    )
  (testing "Padded case"
    (= (list \space \space \#) (add-point () (struct point :rock 2))))
  (testing "Pre-populated list"
    (= (list \# \space \space \space \>) (add-point (list \#) (struct point :up 4))))
  )

(deftest converting
  (testing "Simple case"
    (= (list (struct point :rock 2) (struct point :up 6))
       (to-points [:rock 2 :up 6]))))
