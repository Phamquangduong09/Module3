package com.example.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/")
public class StudentServlet extends HttpServlet {
    public static List<Student> studentList = new ArrayList<>();
    Student student1 = new Student(1, "Duong", 23);
    Student student2 = new Student(2, "Thai", 25);
    Student student3 = new Student(3, "Dung", 21);

    @Override
    public void init() throws ServletException {
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listStudent",studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Student.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
