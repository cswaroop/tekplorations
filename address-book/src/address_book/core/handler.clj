(ns address-book.core.handler
  (:require [compojure.core :refer [defroutes routes]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [address-book.core.routes.address-book-routes :refer [address-book-routes]]))

(defn init
  []
  (println "Initializing Address book application"))


(defroutes app-routes
  (route/not-found "Not Found"))


(def app
  (-> (routes 
       address-book-routes 
       app-routes)
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))
 
