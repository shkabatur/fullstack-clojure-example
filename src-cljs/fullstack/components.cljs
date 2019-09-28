(ns fullstack.components
    (:require [reagent.core :as r]))

(defonce click-count (r/atom 0))
(defn state-ful-with-atom []
    [:div {:on-click #(swap! click-count inc)}
        "I have been clicked " @click-count " times."])