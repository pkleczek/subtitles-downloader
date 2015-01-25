(defproject subtitles-downloader "0.1.0-SNAPSHOT"
  :description "Download subtitles using SubDB API from command line"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
    [digest "1.4.4"]
    [clj-http "1.0.1"]]
  :main ^:skip-aot subtitles-downloader.core
  :target-path "target/%s"
  :plugins [[lein-gorilla "0.3.4"]]
  :profiles {:uberjar {:aot :all}})
