(ns address-book.core.models.query-defs
  (:require [environ.core :refer [env]]
            [yesql.core :refer [defqueries]]))

(defqueries "address_book/core/models/postgres.sql" {:connection (env :database-url)})
