CREATE OR REPLACE FUNCTION getAllUsers()
  RETURNS SETOF users
AS
'
  SELECT *
  FROM users;
'
LANGUAGE SQL;