package com.example.productmanage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
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
        request.setAttribute("product", productManage.getProduct());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("brand", brandManage.getBrand());
        request.getRequestDispatcher("createProduct.jsp").forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        Brand brand = BrandManage.getInstance().getBrandById(brandId);
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        Product product = new Product(name, price, brand, color, describe);
        productManage.addProduct(product);
        response.sendRedirect("/");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productManage.getById(id);
        if (product != null) {
            request.setAttribute("brand", brandManage.getBrand());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
            request.setAttribute("product", product);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        Brand brand = BrandManage.getInstance().getBrandById(brandId);
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");

        Product product = productManage.getById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setBrand(brand);
            product.setColor(color);
            product.setDescribe(describe);
            response.sendRedirect("/products");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        productManage.deleteById(id);
        response.sendRedirect("/products");
    }


}
