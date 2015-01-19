(ns core-async.core
  (:require [clojure.core.async :as a :refer [>! <! >!! <!! go chan buffer close! thread alts! alts!! timeout]])
  (:gen-class))

(def echo-chan (chan)) ; create a channel
(go (println (<! echo-chan))) ; create a go-block to pull a message out of chan (blocking call)
(>!! echo-chan "ketchup") ; put a message


;; go block potentially runs in a seperate thread(depends on host env)






