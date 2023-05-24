create database btvn_day3;
use btvn_day3;
CREATE TABLE class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    sex INT DEFAULT '1' NOT NULL,
    age INT NOT NULL,
    CHECK (17 < age AND age < 25),
    email VARCHAR(50) NOT NULL UNIQUE,
    phone VARCHAR(10) NOT NULL,
    class_id INT,
    FOREIGN KEY (class_id)
        REFERENCES class (id)
);
insert into class ( name ) values
("C0223I1"),
("C0223G1"),
("C0323I1"),
("C0423H1"),
("C0822H1"),
("C1022I1");
select*from class;
select*from student;
insert into student (name , address,sex,age,email,phone,class_id) values
("Thái", "Hà Nội",1,24,"123@gmail.com","0123456798",5),
("Dũng", "Hà Giang",1,20,"ppqd109@gmail.com","0123456789",1), 
("Ly", "Bắc Kan",1,24,"ppqd209@gmail.com","0123456789",2),
("Chữ", "Bắc Ninh",1,22,"ppqd309@gmail.com","0123456789",3),
("Hiếu", "Quảng Ninh",1,22,"ppqd409@gmail.com","0123456789",4),
("Vân", "HCM",0,19,"ppqd509@gmail.com","0123456789",5),
("Thái Anh", "Đà Nẵng",0,22,"ppqd609@gmail.com","0123456789",3),
("Long", "HCM",1,20,"ppqd709@gmail.com","0123456789",4),
("Linh", "Hà Nội",0,19,"ppqd8909@gmail.com","0123456789",1);
select*from student
where sex = "1";
select student.name ,student.age from student
where  age < 20;
select student.name ,student.address from student
where address = "Hà Nội" or address = "Đà Nắng" or address = "HCM";
select student.name ,student.address from student
where address !="Hà Nội";
select*from student
where name like 'H%';
select*from student
where name like '%Anh';
select*from student
join class on class_id = class.id
where class.name = "C0822I1";