(defproject fullstack "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.439"]
                 [http-kit "2.4.0-alpha4"]
                 [compojure "1.6.1"]
                 [cheshire "5.9.0"]
                 [overtone/at-at "1.2.0"]
                 [hiccup "2.0.0-alpha2"]
                 [org.clojure/core.async  "0.4.500"]
                 [cljs-http "0.1.46"]
                 [reagent "0.9.0-rc1"]]
 
  :main ^:skip-aot fullstack.core
  
  :plugins
   [[lein-cljsbuild "1.1.7"]]

  :cljsbuild
  {:builds
   [{
     :source-paths ["src-cljs"]
     :compiler {:output-to "resources/public/js/main.js"
                :optimizations :whitespace
                :pretty-print true}}]}
  
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}

  :aliases
  {"start" ["do" "clean," "cljsbuild" "once," "run"]}
)