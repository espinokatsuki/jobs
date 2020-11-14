DROP DATABASE IF EXISTS jobs;

CREATE DATABASE jobs;

SHOW DATABASES;

USE jobs;

CREATE TABLE category
(
    id          INT(11)      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    CONSTRAINT category_pk
        PRIMARY KEY (id)
);

CREATE TABLE profile
(
    id      INT(11)      NOT NULL AUTO_INCREMENT,
    profile VARCHAR(100) NOT NULL,
    CONSTRAINT profile_pk
        PRIMARY KEY (id)
);

CREATE TABLE vacant
(
    id          INT(11)                                 NOT NULL AUTO_INCREMENT,
    name        VARCHAR(200)                            NOT NULL,
    description TEXT                                    NOT NULL,
    date        DATE                                    NOT NULL,
    salary      DOUBLE                                  NOT NULL,
    status      ENUM ('Created', 'Approved', 'Deleted') NOT NULL,
    highlighted INT(11)                                 NOT NULL,
    image       VARCHAR(250)                            NOT NULL,
    details     TEXT,
    id_category INT(11)                                 NOT NULL,
    CONSTRAINT vacant_pk
        PRIMARY KEY (id),
    CONSTRAINT vacant_category_fk
        FOREIGN KEY (id_category) REFERENCES category (id)
            ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE user
(
    id            INT(11)      NOT NULL AUTO_INCREMENT,
    name          VARCHAR(45)  NOT NULL,
    email         VARCHAR(100) NOT NULL,
    user_name     VARCHAR(45)  NOT NULL,
    password      VARCHAR(100) NOT NULL,
    status        INT(11)      NOT NULL DEFAULT 1,
    register_date DATE                  DEFAULT NULL,
    CONSTRAINT user_pk
        PRIMARY KEY (id)
);

CREATE TABLE job_application
(
    id        INT(11)      NOT NULL AUTO_INCREMENT,
    date      DATE         NOT NULL,
    file      VARCHAR(250) NOT NULL,
    comment   TEXT,
    id_vacant INT(11)      NOT NULL,
    id_user   INT(11)      NOT NULL,
    CONSTRAINT job_application_pk
        PRIMARY KEY (id),
    CONSTRAINT job_application_vacant_fk
        FOREIGN KEY (id_vacant) REFERENCES vacant (id),
    CONSTRAINT job_application_user_fk
        FOREIGN KEY (id_user) REFERENCES user (id)
);

CREATE TABLE user_profile
(
    id_user    INT(11),
    id_profile INT(11),
    CONSTRAINT user_profile_uk
        UNIQUE KEY (id_user, id_profile),
    CONSTRAINT user_profile_user_id_fk
        FOREIGN KEY (id_user) REFERENCES user (id),
    CONSTRAINT user_profile_profile_id_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

SHOW TABLES;

SELECT *
FROM vacant;

INSERT INTO vacant(name, description, date, salary, status, highlighted, image, details, id_category)
VALUES ('Vacant 1', 'Vacant description', '2020-06-14', 1000.0, 'Created', 1, 'no', 'details', 7)