(ns fullstack.core
  (:use [org.httpkit.server :only [run-server]]
        [cheshire.core :only [generate-string parse-string]]
        [compojure.route :only [files not-found resources]]
        [compojure.core :only [defroutes GET POST]]
        [fullstack.views :only [index]])
  (:gen-class))

(defonce server (atom nil))

(def nodes [
            {:river 123
             :light 332
             :ice 15
             :fent 43}])

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn start-server [app]
  (when (nil? @server)
    (reset! server (run-server app {:port 80}))))

(defroutes app
  (GET "/" [] #'index)
  (GET "/nodes" []
       (fn [req]
         {:status 200
          :headers {"Content-Type" "application/json"}
          :body (generate-string nodes)}))
  (resources "/")
  (not-found "<p>Page not found.</p>"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (reset! server (run-server #'app {:port 80})))
