(defproject address-book "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [midje "1.6.3"]
                 [org.clojure/java.jdbc "0.3.6"]
                 [postgresql/postgresql "9.3-1102.jdbc41"]
                 [yesql "0.5.0-rc1"]
                 [environ "1.0.0"]
                 ;[com.cemerick/drawbridge "0.0.6"]
                 [hiccup "1.0.5"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-midje "3.1.3"]
            [lein-environ "1.0.0"]]
  :ring {:handler address-book.core.handler/app
         :init address-book.core.handler/init
         :nrepl {:start? true  
                 :port 9998}}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
