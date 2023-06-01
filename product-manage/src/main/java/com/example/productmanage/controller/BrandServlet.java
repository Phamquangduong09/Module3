package com.example.productmanage.controller;

import com.example.productmanage.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BrandServlet", value = "/brand")
public class BrandServlet extends HttpServlet {

    private final BrandService brandService = BrandService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                displayAll(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
        }
    }
    private void displayAll(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/brand/home.jsp");
        request.setAttribute("brand", brandService.displayAll());
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/brand/create.jsp");
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        brandService.save(request);
        response.sendRedirect("/brand");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (brandService.checkById(id)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/brand/update.jsp");
            request.setAttribute("brand", brandService.getById(id));
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (brandService.checkById(id)) {
            brandService.save(request);
            response.sendRedirect("/brand");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (brandService.checkById(id)) {
            brandService.deleteById(id);
            response.sendRedirect("/brand");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
}
