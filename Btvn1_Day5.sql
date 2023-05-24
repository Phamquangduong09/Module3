create database btvn1_day5;
use btvn1_day5;
CREATE TABLE class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    gender INT DEFAULT 1 NOT NULL,
    CHECK (gender = 1 OR gender = 0),
    age INT NOT NULL,
    CHECK (age >= 18 AND age <= 30),
    email VARCHAR(50) NOT NULL UNIQUE,
    phone VARCHAR(10) NOT NULL
);
-- Thêm cột class_id
alter table students
add column class_id int;
-- Thêm khóa ngoại cho bảng Student
alter table students 
add foreign key(class_id) references class(id);
-- Thêm 5 lớp vào bảng Class
insert into class(name) values
 ("C0223I1"),
 ("C0223G1"),
 ("C0323I1"),
 ("C0423I1"),
 ("C1122H1");
-- Thêm 10 học viên 
insert into students(name, address, gender, age, email, phone, class_id) values
("Dương","Hà Giang",1,22,"phamquangduong009@gmail.com","0399740327",1),
("Thái","Hà Nội",1,24,"321@@gmail.com","0123456789",1),
("Dũng","Hà Giang",1,20,"123@gmail.com","0399740327",4),
("Đức","Hà Nội",1,28,"213@gmail.com","0399740327",2),
("Lâm","Hà Nội",1,27,"456@gmail.com","0399740327",2),
("Hiếu","Quảng Ninh",1,27,"476@gmail.com","0399740327",2),
("Vân","Đà Nẵng",0,24,"876@gmail.com","0399740327",5);
-- Sắp xếp theo tên 
SELECT 
    *
FROM
    students
ORDER BY name;
-- Sắp xếp theo tuổi 
SELECT 
    *
FROM
    students
ORDER BY age DESC;
-- Tổng số lượng học viên mỗi lớp 
select class.name AS Lớp, 
COUNT(students.id) AS Tổng_số_lượng_học_sinh from class
Join students ON class.id = students.class_id
Group By class.name;
-- Tạo view class:
CREATE VIEW student_infor AS
    SELECT 
        class.name, COUNT(class.name) AS so_luong_hs
    FROM
        students
            JOIN
        class ON students.class_id = class.id
    GROUP BY class.name;
-- Lớp có số học viên đông nhất
SELECT 
    *
FROM
    student_infor
WHERE
    so_luong_hs = (SELECT 
            MAX(so_luong_hs)
        FROM
            student_infor);
-- Lớp có số học viên ít nhất
SELECT 
    *
FROM
    student_infor
WHERE
    so_luong_hs = (SELECT 
            MIN(so_luong_hs)
        FROM
            student_infor);
-- Thống kê số lượng học viên theo địa chỉ
SELECT 
    address, COUNT(address) AS so_luong_hs
FROM
    students
GROUP BY address;
-- Hiển thị những lớp có số lượng học viên lớn hơn 5
SELECT 
    *
FROM
    student_infor
WHERE
    so_luong_hs > 5;
-- Hiển thị những thành phố có số lượng học viên lớn hơn 5
SELECT 
    address, COUNT(address) AS so_hoc_sinh
FROM
    students
GROUP BY address
HAVING so_hoc_sinh > 5;
-- Hiển thị học viên có tuổi lớn nhất
SELECT 
    *
FROM
    students
WHERE
    age = (SELECT 
            MAX(age)
        FROM
            students);
 -- Hiển thị học viên có tuổi nhỏ nhất
 select * from students
where age = (select min(age) from students);
-- Xóa tất cả học viên có quê ở Hà Nội
delete from students where address = "Hà Nội";
-- Cập nhật thông tin của học viên có quê ở Hà Nội thành giới tính nữ
update students set sex = 0 where address = "Hà Nội" ;
-- Hiển thị học viên có số tuổi lớn thứ hai
delimiter //
create procedure get_2nd_max_age()
begin
select max(age) from students into @max_age;
select * from students where age = ( select max(age) from students where age < @max_age);
end
// delimiter ;
 call get_2nd_max_age();

