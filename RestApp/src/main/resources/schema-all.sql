DROP TABLE people if EXISTS;

CREATE TABLE people (
	person_id BIGINT NOT NULL PRIMARY KEY,
	first_name VARCHAR(20),
	last_name VARCHAR(20) );