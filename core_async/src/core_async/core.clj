(ns core-async.core
  (:require [clojure.core.async :as a :refer [>! <! >!! <!! go chan buffer close! thread alts! alts!! timeout]])
  (:gen-class))

(def echo-chan (chan)) ; create a channel
(go (println (<! echo-chan))) ; create a go-block to pull a message out of chan (blocking call)
(>!! echo-chan "ketchup") ; put a message


;; go block potentially runs in a seperate thread(depends on host env)


;; futures

(let [result (future (println "This prints once")
                     (+ 1 1))]
  (println @result)
  (println @result))

(let [result (future (Thread/sleep 3000)
                     (+ 1 1))]
  (println "The result is " @result)
  (println "It must have been 3 sec elapsed before I print"))

;; delays

(def jackson-5-delay
  (delay (let [message "Just call my name and I will be there"]
           (println "First deref" message)
           message)))

(force jackson-5-delay)
(force jackson-5-delay) ; its already cached


;; another delay

(def gimli-headshots ["serious.jpg" "fun.jpg" "playful.jpg"])
(defn email-user
  [email-address]
  (println "Sending notification to " email-address))

(defn upload-document
  "Needs to be implemented"
  [headshot]
  true)

(let [notify (delay (email-user "and-my-axe@gmail.com"))]
  (doseq [headshot gimli-headshots]
    (future (upload-document headshot)
            (force notify))))

; promises


(def my-promise (promise))
(deliver my-promise (+ 1 2))
@my-promise

;; try to deliver again. it will not

(deliver my-promise (+ 1 4))


