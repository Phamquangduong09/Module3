package com.example.productmanage.controller;

import com.example.productmanage.model.Brand;
import com.example.productmanage.model.Product;
import com.example.productmanage.service.BrandManage;
import com.example.productmanage.service.ProductManage;

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
            case "detail":
                detail(request,response);
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/brand/homeBrand.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/brand/createBrand.jsp");
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
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/brand/updateBrand.jsp");
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

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Brand brand = brandManage.getBrandById(id);
        int i = 0;
        for (Product p: productManage.getProduct()){
            if(p.getBrand().getName().equals(brand.getName())){
                i++;
            }
        }
        if (brand != null) {
            request.setAttribute("sum",i);
            request.setAttribute("brand",brand.getName());
            request.setAttribute("product", productManage.getProduct());
            request.getRequestDispatcher("/brand/detailBrand.jsp").forward(request,response);
        }



    }


}
