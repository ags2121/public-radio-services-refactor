CREATE TABLE request (
  id integer PRIMARY KEY,
  name VARCHAR(200) not null,
  requestor VARCHAR(100),
  email VARCHAR(30),
  url VARCHAR(2083) not null,
  created_at timestamp not null default current_timestamp
);
