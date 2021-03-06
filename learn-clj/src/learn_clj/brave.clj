(ns learn-clj.brave)

; forms

(+ 1 2)

(str "Hello" "World")

(if true
  "abra cadabra"
  "hocus pocus") ; return abra cadabra

(when true
  (println "Success")
  "success!")

(if true 
  (do (println "Success!")
      "abra cadabra")
  (do (println "Failure!")
      "hocus pocus"))

;; local bindings

(def name "Chewbecca")



; (immutable and transient) data structures

;; lists ()

'(1 2 3)
(list 1 2 3 4) ; => (1 2 3 4)
(nth '(1 2 3) 3); do you know the cost of this?
(conj '(1 2 3) 4)


;; vectors []

[]
(get [3 2 1] 0)
(get ["a" {:name "Pugsley Winterbottom"} "c"] 1) ; => {:name "Pugsley Winterbottom}

(vector 1 2 3) ; => [1 2 3]

;; sets #{}

#{:a :b :c} ; => #{:a :b :c}
(get #{:a :b} :b)
(get #{:a :b} "hannah montana") ; => nil
(:a #{:a :b}) ; => :a
(conj #{:a :b} :b) => #{:a :b}

(set [1 2 3 4 4]) ; => #{1 2 3 4}
(get (set [1 2 2 2 3]) 3)  ; => 3

(hash-set 1 1 2 3 4)
(sorted-set :b :a :c) ; sorted-set-by to pass sort function


;; maps {}

(get {:a 1 :b 2} :b)
(get {:a 1 :b 2} :c)
(get {:a 1 :b 2} :c "UNICORNS")

(get-in {:a :b {:c "ho hum"}} [:b :c]) ; => "ho hum"

({:a 1 :b 2} :a); => 1
(:a {:a 1 :b 2 :c 3}) ; => 1
(:d {:a 1 :b 2 :c 3} "UNICORNS") ; => "UNICORNS"

(hash-map :a 1 :b 2) ;

;; there is no map operator to create maps.  map is a HOF

;; records

;; symbols as data

(identity 'test) ; => test


;functional programming

;; Functions are first-class. define, call, return named and anonymous functions

;; generatlize over processes(conj) not nouns (Vehicle->Car). Functional vs OO

;; whole clojure is defined out of very few special forms; infact
;; McCarthy had defined whole lisp with7 special forms car, cdr, first, next etc.
;; He must have invented such as simple language, because he already have enough complexity to deal with (AI). (rant)

;; anymous functions

(fn [x] (* x 3))
#(* % 3)
(#(* % 3) 8)
(map #(str "Hi, " %) ; % is like %1
     ["Darth Vader" "Mr. Magoo"])


;; Higher-order-programmin.g (HOP)

;;; map
;;; reduce
;;; comp;
;;; into
;;; conj
;;; concat
;;; some
;;; filter
;;; take
;;; drop
;;; sort
;;; sort-by
;;; identity
;;; apply
;;; partial
;;; complement


;; reducers
;; transducers
;; destructuring

; macros

;; quote
;; syntax quote
;; unquote
;; unquote-splicing
;; gensym
;; autogensym
;; macroexpand
;; double evaluations
;; variable capture
;; macros all the way down


;; reader forms 

(eval (read-string "(+ 8 3)"))
(eval '(+ 1 4))

(read-string "#(+ 1 %)")

(def a-list (list + 1 2))
(eval a-list)

;; -> as best-known macro which changes the order of evaluation

(defn read-resource
  "Read a resource into a string"
  [path]
  (read-string (slurp (io/resource path))))

(defn read-resource
  [path]
  (-> path
      io/resource
      slurp
      read-string))

;; macroexpand

(defmacro postfix-notation
  [expression]
  (conj (butlast expression) (last expression)))

(postfix-notation (1 1 +))
(macroexpand '(postfix-notation (1 1 +)))

;; you can use destructing too with macros

(defmacro code-critic
  [{:keys [good bad]}]
  (list 'do
        (list 'println "This is bad code" (list 'quote bad))
        (list 'println "This is good code" (list 'quote good))))

(code-critic {:good (+ 1 1) :bad (1 + 1)})


;; multiple-arity macros  e.g. `and` `or`

;; macros need quote and quote to constantly switch between expansion and evaluation. lets understand the quoting business

(+ 1 2)
(quote (+ 1 2))
+
(quote +)
(quote sweating-to-the-oldies)

(defmacro when
  [test & body]
  (list 'if test (cons 'do body)))

(macroexpand '(when (the-cows-come :home)
             (call me :pappy)
             (slap me :silly)))

(defmacro unless
  [test & brances]
  (conj (reverse branches) test 'if))

(macroexpand '(unless (done-been slapped? me)
                      (slap me :silly)))

(defmacro code-critic
  [{:keys [good bad]}]
  `(do (println "Bad code" (quote ~bad))
       (println "Good code" (quote ~good))))

(defmacro code-praiser
  [code]
  `(println "Good code" (quote ~code)))


; concurrency

;; atoms
;; vars
;; agents
;; futures
;; delays
;; promise
;; core.async

; interaction with java

;; Java Swing


; 
