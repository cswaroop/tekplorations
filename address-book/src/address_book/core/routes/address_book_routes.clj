(ns address-book.core.routes.address-book-routes
  (:require [compojure.core :refer :all]
            [ring.util.response :as response]
            [address-book.core.views.address-book-layout :refer [common-layout
                                                                 read-contact
                                                                 add-contact-form]]
            [address-book.core.models.query-defs :as query]))

(def contacts (atom [{:id 1 
                      :name "Jarrod" 
                      :phone "(555) 666-6666" 
                      :email "Jarrod@Jarrod"}
                     {:id 2 
                      :name "James" 
                      :phone "(333) 344-4443" 
                      :email "James@James"}
                     {:id 3 
                      :name "Johnny" 
                      :phone "(444) 333-3333" 
                      :email "Johnyy@Johnyy"}]))

(defn next-id []
  (->>
   @contacts
   (map :id)
   (apply max)
   (+ 1)))

(defn post-route [request]
  (let [name (get-in request [:params :name])
        phone (get-in request [:params :phone])
        email (get-in request [:params :email])]
    ;(swap! contacts conj {:id (next-id) :name name :phone phone :email email})
    (query/insert-contacts<! {:name name :phone phone :email email})
    (response/redirect "/")))

(defn get-route [request]
  (common-layout
   (for [contact (query/all-contacts)]
     (read-contact contact))
   (add-contact-form)))

(defn example-post [request]
  (let [post-value (get-in request [:params :example-post])]
    (str "You posted: " post-value)))

(defn example-get [request]
  (common-layout
   [:p "Example GET"]))

(defroutes address-book-routes
  (GET "/" [] get-route)
  (POST "/post" [] post-route))
