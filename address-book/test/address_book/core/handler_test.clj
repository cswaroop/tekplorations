(ns address-book.core.handler-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [address-book.core.handler :refer :all]))

;; (deftest test-app
;;   (testing "main route"
;;     (let [response (app (mock/request :get "/"))]
;;       (is (= (:status response) 200))
;;       (is (= (:body response) "Hello World"))))

;;   (testing "not-found route"
;;     (let [response (app (mock/request :get "/invalid"))]
;;       (is (= (:status response) 404)))))

(facts "Example GET and POST tests"

   (fact "Test GET"
         (let [response (app (mock/request :get "/"))]
           (:status response) => 200
           (:body response) => (contains "Example GET")))
   (fact "Test POST"
         (let [response (app (mock/request :post "/post" {:example-post "Some Data"}))]
           (:status response) => 200
           (:body response) => "You posted: Some Data")))
