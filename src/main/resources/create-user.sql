CREATE TABLE users
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(50)    NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

INSERT INTO users (name, balance)
VALUES ('Alice', 1000.00),
       ('Bob', 500.00);