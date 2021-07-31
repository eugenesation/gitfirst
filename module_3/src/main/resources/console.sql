insert into users (id, email, name) VALUES (1, '1111', 'Evgeny Smirnov');

insert into accounts (id, number, balance, created, user_id) VALUES (1, 33432123, 500, current_timestamp, 1);

insert into categories (id, name, type) VALUES
(1, 'salary', 'INCOME'),
(2, 'personal funds income transfer', 'INCOME'),
(3, 'cashback', 'INCOME'),
(4, 'personal funds expense transfer', 'EXPENSE'),
(5, 'online purchases', 'EXPENSE');