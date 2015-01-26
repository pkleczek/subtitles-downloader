(ns subtitles-downloader.core
  (:require [subtitles-downloader.hash-calc :as calc])
  (:require [subtitles-downloader.subdb-api :as sub])
  (:gen-class))

(defn -main
  [& args]
  (when-not (empty? args)
    (let [file-name (first args) lang (keyword (second args)) hash (calc/calculate-hash file-name)]
      (if-let [langs (seq (sub/get-languages-for-hash hash))]
        (if (some #{lang} langs)
          (sub/get-subtitles hash lang)
          (println "Available languages are: " langs))
        (println "No subtitles found :(")))))
