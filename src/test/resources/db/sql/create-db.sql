CREATE TABLE PUBLIC.PROPERTIES(
   CONTEXT VARCHAR(25) NOT NULL,
   KEY VARCHAR(25) NOT NULL,
   VALUE VARCHAR(50),
   DESCRIPTION VARCHAR(500),
   PRIMARY KEY(CONTEXT, KEY)
);