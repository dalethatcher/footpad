(ns footpad.test.core
  (:use [footpad.core] :reload)
  (:use [clojure.test]))

(deftest three-by-three-grid-creation
  (is (= (generate-rock 3 3)
         '((\# \# \#)
          (\# \# \#)
          (\# \# \#)))))
