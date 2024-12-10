CREATE TABLE transactions
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT         NOT NULL,
    amount           DECIMAL(10, 2) NOT NULL,
    transaction_date DATETIME       NOT NULL,
    description      VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- 插入範例數據
INSERT INTO transactions (user_id, amount, transaction_date, description)
VALUES (1, -50.00, '2024-12-10 10:00:00', 'Buy coffee'),
       (1, -200.00, '2024-12-10 11:00:00', 'Buy groceries'),
       (2, 100.00, '2024-12-10 12:00:00', 'Transfer from Alice');