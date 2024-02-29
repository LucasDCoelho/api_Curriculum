CREATE TABLE user_role (
                           name VARCHAR(255) PRIMARY KEY,
                           description VARCHAR(255)
);


INSERT INTO user_role (name, description)
VALUES ('DEV', 'Developer'), ('ADMIN', 'Administrator'), ('USER', 'User');

CREATE TABLE users (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       login VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL CHECK (role IN ('DEV', 'ADMIN', 'USER')),
                       CONSTRAINT fk_user_role FOREIGN KEY (role) REFERENCES user_role (name)
);




