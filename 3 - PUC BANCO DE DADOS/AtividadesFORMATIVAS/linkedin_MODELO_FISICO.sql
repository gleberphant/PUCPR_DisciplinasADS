/* Lógico_1: */

CREATE TABLE user (
    first_name VARCHAR,
    last_name VARCHAR,
    password VARCHAR
);

CREATE TABLE school (
    type CHAR,
    location TIMESTAMP,
    founded_year DATE,
    name VARCHAR
);

CREATE TABLE companie (
    name VARCHAR,
    industry CHAR,
    location VARCHAR
);

CREATE TABLE follow (
);

CREATE TABLE affiliation (
    end_date DATE,
    start_date DATE
);

CREATE TABLE alumni (
    start_date DATE,
    end_date DATE,
    degree CHAR
);