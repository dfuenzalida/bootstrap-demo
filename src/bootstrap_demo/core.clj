(ns bootstrap-demo.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.webjars :refer [wrap-webjars]]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(def app (-> handler
             (wrap-resource "public")
             wrap-webjars))

(def port 3000)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Running app in port" port)
  (run-jetty app {:port port}))

