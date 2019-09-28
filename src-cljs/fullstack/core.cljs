(ns fullstack.core
     (:require-macros [cljs.core.async.macros :refer [go]])
     (:require [cljs-http.client :as http]
               [cljs.core.async :refer [<!]]
               [reagent.core :as r])
               [fullstack.components :only [state-ful-wth-atom]])

(enable-console-print!)

(println "HEY!")
(def nodes (atom nil))


(defn mountit []
    (r/render [state-ful-with-atom]
        (.-body js/document)))

(mountit)

(go (let [response (<! (http/get "/nodes"))]
  (swap! nodes (js->clj (:body response)))
  (println @nodes)))