(defproject bootstrap-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [;; backend
                 [org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring-webjars "0.2.0"]

                 ;; resources
                 [org.webjars/bootstrap "3.4.0"]
                 [cljsjs/bootstrap "3.3.6-1"]

                 ;; front-end
                 [org.clojure/clojurescript "1.10.439"]
                 [reagent "0.8.1"]]
  :main ^:skip-aot bootstrap-demo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
