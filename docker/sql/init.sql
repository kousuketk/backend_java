DROP database if exists springdb;
CREATE DATABASE springdb;
USE springdb;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users(id, name, email) VALUES(1, 'test_user1', 'test_user1@test.com');
INSERT INTO users(id, name, email) VALUES(2, 'test_user2', 'test_user2@test.com');
INSERT INTO users(id, name, email) VALUES(3, 'test_user3', 'test_user3@test.com');
INSERT INTO users(id, name, email) VALUES(4, 'test_user4', 'test_user4@test.com');