CREATE TABLE citator.User (
    id          SERIAL NOT NULL PRIMARY KEY,
    username    varchar(40) NOT NULL,
    email       varchar(40) NOT NULL,
    nickname    varchar(40) NOT NULL,
    password    varchar(40) NOT NULL
);