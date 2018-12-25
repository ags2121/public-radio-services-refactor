-- :name create-request! :! :n
-- :doc creates a new request record
INSERT INTO request
(
id,
name,
requestor,
email,
url,
created_at)
VALUES
(
:id,
:name,
:requestor,
:email,
:url,
:created_at)

-- :name get-requests
-- :doc retrieves all requests
SELECT * FROM request
