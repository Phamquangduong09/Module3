create database baitap2_day3;
use baitap2_day3;
CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    CHECK (age >= 18)
);
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    c_id INT,
    FOREIGN KEY (c_id)
        REFERENCES customer (id),
    o_date DATETIME,
    total_price DOUBLE DEFAULT '0'
);
CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    price DOUBLE DEFAULT '0'
);
CREATE TABLE order_detail (
    o_id INT,
    p_id INT,
    FOREIGN KEY (o_id)
        REFERENCES orders (id),
    FOREIGN KEY (p_id)
        REFERENCES product (id),
    quantity INT,
    CHECK (quantity > 0)
);
insert into customer( name,age)values
("Minh Quan " , 19),
("Ngoc Oannh " , 20),
("Hong Ha " , 20);
insert into orders ( c_id , O_date ) values
( 2,"2023-05-17");
insert into product ( name, price ) values
("May giat",5),
("Tu lanh",3),
("Dieu hoa",8),
("Quat",2);
insert into order_detail(o_id,p_id,quantity) values
(1,1,3),
(1,3,4);
select customer.name, product.name  as product from customer
join orders on customer.id = orders.c_id join order_detail on orders.id = order_detail.o_id join product on order_detail.p_id = product.id;


