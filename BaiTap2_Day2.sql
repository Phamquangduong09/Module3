create database baitap2_day2;
use baitap2_day2;
CREATE TABLE customer (
    cID INT PRIMARY KEY AUTO_INCREMENT,
    cName VARCHAR(50),
    cAge INT
);
CREATE TABLE orders (
    oID INT PRIMARY KEY AUTO_INCREMENT,
    cID INT,
    FOREIGN KEY (cID)
        REFERENCES customer (cID),
    oDate DATETIME,
    oTotalPricce DOUBLE
);
CREATE TABLE product (
    pID INT PRIMARY KEY AUTO_INCREMENT,
    pName VARCHAR(50),
    pPrice DOUBLE
);
CREATE TABLE orderDaily (
    oID INT,
    pID INT,
    odQTY VARCHAR(50)
);
