package com.example.productmanage.controller;

import com.example.productmanage.DAO.CartDAO;
import com.example.productmanage.service.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {

    private final CartService cartService = CartService.getInstance();
    private final CartDAO cartDAO = CartDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteCart(request, response);
                break;
            case "add":
                addToCart(request, response);
                break;
            case "updateQuantity":
                updateQuantity(request, response);
                break;
            default:
                displayAll(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cart", CartService.getInstance().displayAll());
        request.setAttribute("total", CartDAO.getInstance().getTotalPrice());
        request.getRequestDispatcher("/cart/home.jsp").forward(request, response);
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cartService.deleteById(request);
        response.sendRedirect("/cart");
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cartService.addToCart(request);
        response.sendRedirect("/product");
    }

    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        cartDAO.updateCartQuantity(id,quantity);
                response.sendRedirect("/cart");
    }
}
