CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY,
  partial_name VARCHAR(255)
);

INSERT INTO users (id, partial_name) VALUES (1, 'Stepan');
INSERT INTO users (id, partial_name) VALUES (2, 'Vova');
INSERT INTO users (id, partial_name) VALUES (3, 'Alex');
INSERT INTO users (id, partial_name) VALUES (4, 'Igor');
INSERT INTO users (id, partial_name) VALUES (5, 'Pankesh');
