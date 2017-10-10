CREATE TABLE Spittle (
  id         IDENTITY,
  message    VARCHAR(140) NOT NULL,
  created_at TIMESTAMP    NOT NULL,
  latitude   DOUBLE,
  longitude  DOUBLE
);

CREATE TABLE Spitter (
  id         IDENTITY,
  username   VARCHAR(20) UNIQUE NOT NULL,
  password   VARCHAR(20)        NOT NULL,
  first_name VARCHAR(30)        NOT NULL,
  last_name  VARCHAR(30)        NOT NULL,
  email      VARCHAR(30)        NOT NULL
);