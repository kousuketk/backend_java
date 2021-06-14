DROP database if exists sample_db;
CREATE DATABASE sample_db;
USE sample_db;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users(id, name, email) VALUES(1, 'test_user1', 'test_user1@test.com');
INSERT INTO users(id, name, email) VALUES(2, 'test_user2', 'test_user2@test.com');
INSERT INTO users(id, name, email) VALUES(3, 'test_user2dd', 'test_user2@test.com01');