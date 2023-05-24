create database demo;
use demo;
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    gender VARCHAR(50)
);
select*from student;
alter table student
add column class varchar(50);
insert into student(name,age,gender,class)value
( "Duong", 24, "Male","C02i1"),
( "Thai", 26, "Male","C02i1"),
( "Ly", 30, "Male","C02i1");
delete from student where name = "Duong";