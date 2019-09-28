(ns fullstack.views
  (:use
   [hiccup.page :only [html5 include-css include-js]]))

(defn index [req]
 (html5 [:head
         [:meta {:charset "utf-8"}]]
        [:body
         [:h1 "KEK"]
         [:script {:src "js/main.js"}]]))
