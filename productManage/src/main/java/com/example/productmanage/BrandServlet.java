package com.example.productmanage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BrandServlet", value = "/brand")
public class BrandServlet extends HttpServlet {
    private final ProductManage productManage = ProductManage.getInstance();
    private final BrandManage brandManage = BrandManage.getInstance();

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
                findAll(request, response);
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

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("brand", brandManage.getBrand());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeBrand.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/createBrand.jsp");
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Brand brand = new Brand(name);
        brandManage.addBrand(brand);
        response.sendRedirect("/brand");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = brandManage.getById(id);
        if (brand != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateBrand.jsp");
            request.setAttribute("brand", brand);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Brand brand = brandManage.getById(id);
        if (brand != null) {
            brand.setName(name);
            response.sendRedirect("/brand");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = brandManage.getBrandById(id);
        if (brand != null) {
            brandManage.deleteById(id);
            productManage.deleteByBrand(brand);
            response.sendRedirect("/brand");
        }
    }


}
