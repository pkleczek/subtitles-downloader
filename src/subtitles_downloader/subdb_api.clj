(ns subtitles-downloader.subdb-api
  (:require [clj-http.client :as http])
  (:require [clojure.string :as string])
  (:gen-class))

  (def user-agent {:user-agent "SubDB/1.0 subtitles-downloader//0.1.0 https://github.com/pkleczek/subtitles-downloader"})

  (defn- do-http-action
    [url success-callback]
    (let [response (http/get url {:headers user-agent})]
      (case (:status response)
        200 (success-callback response)
        nil))
    )

  (defn- parse-languages
    [response]
    (let [trimmed-response (string/split response #",")]
      (map keyword (remove empty? trimmed-response))))

  (defn get-supported-languages
    []
    (do-http-action "http://sandbox.thesubdb.com/?action=languages"
      (fn [response] (parse-languages (:body response)))))

  (defn get-languages-for-hash
    [hash]
    (do-http-action
      (str "http://sandbox.thesubdb.com/?action=search&hash=" hash)
      (fn [response] (parse-languages (:body response)))))
