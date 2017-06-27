CREATE TABLE category(
id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY(id)
);
INSERT INTO category(name,description,image_url,is_active)
VALUES('Mobile','Thease are all regarding to mobiles','1.png','true');

INSERT INTO category(name,description,image_url,is_active)
VALUES('Laptop','Thease are all regarding to Laptop','2.png','true');

INSERT INTO category(name,description,image_url,is_active)
VALUES('Headphone','Thease are all regarding to headphone','3.png','true');



CREATE TABLE user (
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
email VARCHAR(50),
password VARCHAR(50),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),

);


INSERT INTO user
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('dillip kumar','dora','ADMIN','true','dillip1994','dillip@gmail.com','9999999999');

INSERT INTO user
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('arun','rout','SUPPLIER','true','arunrout','arunn@gmail.com','8888888888');

INSERT INTO user
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('biswajit','sahoo','SUPPLIER','true','sahoo','sahoo@gmail.com','7777777777');


CREATE TABLE address (
id IDENTITY,
user_id IDENTITY,
address_line_one VARCHAR(255),
address_line_two VARCHAR(50),
city VARCHAR(50),
state VARCHAR(50),
country VARCHAR(50),
postal_code VARCHAR(50),
shipping BOOLEAN,
billing BOOLEAN,
CONSTRAINT pk_user_id PRIMARY KEY(id),

);

CREATE TABLE cart (
id IDENTITY,
user_id INTEGER,
grand_total DOUBLE,
cart_lines INTEGER,
CONSTRAINT pk_user_id PRIMARY KEY(id),

);






CREATE TABLE product(
id IDENTITY,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchages INT DEFAULT 0,
views INT DEFAULT 0,
CONSTRAINT pk_product_id PRIMARY KEY(id),
CONSTRAINT fk_product_category_id FOREIGN  KEY(category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY(supplier_id) REFERENCES user(id),
);

INSERT INTO product (code, name, brand,description, unit_price, quantity,is_active, category_id, supplier_id, purchages, views)
VALUES('PRDABC123','iphone 5s','apple','It is a best brand mobile','25000','4','true','2','3','0','0');

INSERT INTO product (code, name, brand,description, unit_price, quantity,is_active, category_id, supplier_id, purchages, views)
VALUES('PRDABC124','xiomi redmi','xiomi','It is a user friendly mobile at effective cost','10000','5','true','3','2','0','0');
INSERT INTO product (code, name, brand,description, unit_price, quantity,is_active, category_id, supplier_id, purchages, views)
VALUES('PRDABC125','Hp pavilion','hp','It is the most rated laptop','45000','6','true','3','4','0','0');

INSERT INTO product (code, name, brand,description, unit_price, quantity,is_active, category_id, supplier_id, purchages, views)
VALUES('PRDABC126','macbook pro','apple','It is a best quality laptop','75000','2','true','1','2','0','0');

INSERT INTO product (code, name, brand,description, unit_price, quantity,is_active, category_id, supplier_id, purchages, views)
VALUES('PRDABC127','jbl softcore','jbl','It is a best brand headphone','5000','2','true',3',1','0','0');