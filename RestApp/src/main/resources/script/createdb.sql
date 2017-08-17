CREATE TABLE SPITTER (
  spitter_id BIGSERIAL PRIMARY KEY,
  username VARCHAR(40) NOT NULL UNIQUE,
  password VARCHAR(30) NOT NULL,
  role_user VARCHAR(20) NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  insert_date TIMESTAMP,
  last_update TIMESTAMP,
  enabled BOOLEAN,
  spitter_picture BYTEA
);


CREATE TABLE SPITTLE(
  spittle_id BIGSERIAL PRIMARY KEY,
  message TEXT,
  latitude DECIMAL,
  longitude DECIMAL,
  insert_date TIMESTAMP,
  last_update TIMESTAMP,
  spitter_id INTEGER REFERENCES SPITTER (spitter_id)
);

CREATE TABLE REPOSITORY(
  record_id BIGSERIAL PRIMARY KEY,
  file BYTEA,
  insert_date TIMESTAMP,
  last_update TIMESTAMP,
  spitter_id INTEGER REFERENCES SPITTER (spitter_id)
)

