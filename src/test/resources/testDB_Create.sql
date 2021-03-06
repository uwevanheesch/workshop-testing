
DROP TABLE IF EXISTS STOCK_ITEMS;
CREATE TABLE STOCK_ITEMS(name VARCHAR(255), description VARCHAR(255), PRIMARY KEY(name));

DROP TABLE IF EXISTS ORDER_ITEMS;
CREATE TABLE ORDER_ITEMS(id INT4, description VARCHAR(255), stock_item VARCHAR(255), PRIMARY KEY(id,stock_item));

INSERT INTO STOCK_ITEMS VALUES ('Item1','Item1Description');
INSERT INTO STOCK_ITEMS VALUES ('Item2','Item2Description');

INSERT INTO ORDER_ITEMS VALUES (1,'Order1','Item1');
INSERT INTO ORDER_ITEMS VALUES (1,'Order1','Item2');

