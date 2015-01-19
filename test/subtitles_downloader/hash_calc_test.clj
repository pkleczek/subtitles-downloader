(ns subtitles-downloader.hash-calc-test
  (:require [clojure.test :refer :all]
            [subtitles-downloader.hash-calc :refer :all]))

(deftest should-calculate-hash
  (testing "Predefined file should return valid hash"
    (let [file-name "resources\\lambda.png" hash (calculate-hash file-name)]
      (is (= hash "0bc09adb09d0f15c1508a3d33bdc3905")))))
