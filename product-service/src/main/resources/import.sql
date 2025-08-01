INSERT INTO products (name, author, isbn, price, stock) VALUES ('L''Étranger', 'Albert Camus', '978-2070360024', 6.50, 85);
INSERT INTO products (name, author, isbn, price, stock) VALUES ('Dune, Tome 1', 'Frank Herbert', '978-2266223299', 11.90, 65);
INSERT INTO products (name, author, isbn, price, stock) VALUES ('Clean Code', 'Robert C. Martin', '978-0132350884', 35.50, 90);
INSERT INTO products (name, author, isbn, price, stock) VALUES ('Harry Potter à l''école des sorciers', 'J.K. Rowling', '978-2070643028', 8.70, 250);
INSERT INTO products (name, author, isbn, price, stock) VALUES ('Le Petit Prince', 'Antoine de Saint-Exupéry', '978-2070612758', 8.90, 120);
Attention !
Dans la dernière version de Spring, il est crucial de nommer le fichier de fixtures import.sql et non data.sql. En effet, avec ce dernier nom Spring tentera de charger les données avant que JPA ait généré le schéma.