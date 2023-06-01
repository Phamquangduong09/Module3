package com.example.productmanage.service;

import com.example.productmanage.DAO.CartDAO;
import com.example.productmanage.DAO.ProductDAO;
import com.example.productmanage.model.Cart;
import com.example.productmanage.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class CartService {
    private static CartService cartService;

    private static ProductService productService;
    private static BrandService brandService;
    private final CartDAO cartDAO;

    private CartService() {
        productService = ProductService.getInstance();
        brandService = BrandService.getInstance();
        cartDAO = new CartDAO();

    }

    public static CartService getInstance() {
        if (cartService == null) {
            cartService = new CartService();
        }
        return cartService;
    }

    public List<Cart> displayAll() {
        return cartDAO.displayAll();
    }

    public void addToCart(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = ProductService.getInstance().getById(id);
        Cart cart = new Cart(quantity, product);
//        boolean check = true;
//        int cartId = -1;
//        for (Cart c : CartDAO.getInstance().displayAll()) {
//            if (c.getProduct().getId() == product.getId()) {
//                check = false;
//                cartId = c.getId();
//                break;
//            }
//        }
//        if (check) {
//            CartDAO.getInstance().addCart(cart);
//        } else {
//            CartDAO.getInstance().updateCartQuantity(cartId, quantity);
//        }
//        ProductService.getInstance().updateQuantityDecrease(id, quantity);
    }

    public void deleteById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        cartDAO.deleteById(id);
    }


}
