# address-book

A Sample clojure web application

## Running

To start a web server for the application, run:

    lein ring server 3000

and hit the browser at http://localhost:3000

To run unit tests

	lein midje :autotest

## Development Notes

`lein new compojure address-book`
`lein ring server-headless`

Clojure web stack is made-up of many many small libraries and have child like joy collecting all these pebbles.

* ring and compojure for minimal HTTP abstractions
* http-kit, jetty, netty, immutant for runtime
* hiccup, enlive, selmer for templating - do we need yet another template lang?
* liberator for RESTify

Others include pedestle, om, weasel

### Routes (handler)

Like all the latest micro-web frameworks (sinatra, flask, node-express) modern web app development is Route-First (sure REST-First, Mobile-First, Cloud-First..)

Compojure uses the term handler to define the routes.

``` clojure
(defroutes
	...)
```



