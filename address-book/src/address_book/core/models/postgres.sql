-- name: all-contacts
-- all contacts
SELECT id
       ,name
       ,phone
       ,email
FROM contacts;

-- name: insert-contacts<!
-- insert contacts
INSERT INTO contacts (name, phone, email)
  VALUES (:name, :phone, :email);

-- name: drop-contacts-table!
-- drop contacts
DROP TABLE contacts;

-- name: create-contacts-table-if-not-exists!
-- create the contacts table 
CREATE TABLE IF NOT EXISTS contacts (
       id serial PRIMARY KEY,
       name VARCHAR (20) NOT NULL,
       phone VARCHAR (14) NOT NULL,
       email VARCHAR (25) NOT NULL);
