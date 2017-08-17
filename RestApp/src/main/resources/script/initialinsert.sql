INSERT INTO SPITTER (username,password,role_user,firstname,lastname,email,insert_date,last_update,enabled)
  VALUES
  ('fakeuser','fakepwd','USER','mark','smith','fakemail@domain.com',
    to_timestamp('16-08-2017 11:58:46', 'dd-mm-yyyy hh24:mi:ss'),
    to_timestamp('16-08-2017 11:58:46', 'dd-mm-yyyy hh24:mi:ss'),
    TRUE );

INSERT INTO SPITTLE (message,latitude,longitude,insert_date,last_update,spitter_id)
  VALUES
  ('This is my first message! Wow it is amazing', 34.90, 45.91,
   to_timestamp('16-08-2017 12:04:47', 'dd-mm-yyyy hh24:mi:ss'),
   to_timestamp('16-08-2017 12:04:47', 'dd-mm-yyyy hh24:mi:ss'),
   1 ),
  ('An other message..This is just crazy!!!', 28.28, 14.29,
   to_timestamp('16-08-2017 12:08:07', 'dd-mm-yyyy hh24:mi:ss'),
   to_timestamp('16-08-2017 12:08:07', 'dd-mm-yyyy hh24:mi:ss'),
   1 );

