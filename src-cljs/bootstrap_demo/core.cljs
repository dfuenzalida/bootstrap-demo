(ns bootstrap-demo.core
  (:require [reagent.core :as r]
            [goog.string :as gstring]))

(enable-console-print!)

(defn by-id [elem-id]
  (.getElementById js/document elem-id))

(def unescape
  gstring/unescapeEntities)

;; From the reagent example: https://reagent-project.github.io/
(defonce timer (r/atom (js/Date.)))

(defonce time-updater (js/setInterval
                       #(reset! timer (js/Date.)) 1000))

;; Trigger the JS API of the modal
(defn trigger-modal [modal-id event]
  (println "Triggered with JS on" (js/Date.) "with event" event)
  (-> (js/jQuery modal-id) (.modal #js {:keyboard true})))

(defn modal []
  (let [time-str (-> @timer .toTimeString (clojure.string/split " ") first)]
    [:div#myModal.modal.fade {:role "dialog"}
     [:div.modal-dialog {:role "document"}
      [:div.modal-content
       [:div.modal-header
        [:button.close {:type "button" :data-dismiss "modal"} [:span (unescape "&times;")]]
        [:h4.modal-title "Modal title"]]
       [:div.modal-body
        [:h4 "The current time is: " time-str]]
       [:div.modal-footer
        [:button.btn.btn-default {:type "button" :data-dismiss "modal"} "Close"]]]]]))

(defn app []
  [:div
   [:div.row {:style {:padding-top "20px"}}
    [:div.jumbotron
     [:h2 "Welcome!"]
     [:p.lead "You can use the following buttons to show a modal with the current time: "
      [:button.btn.btn-sm.btn-success {:data-toggle "modal" :data-target "#myModal"} "button without JS"]
      " "
      [:button.btn.btn-sm.btn-success {:on-click #(trigger-modal "#myModal" %) } "trigger with JS"]
      ]]]
   (modal)
   ])

(r/render-component (fn [] [app]) (by-id "app"))

(println "Loaded!")
