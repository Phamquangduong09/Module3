package com.example.productmanage.service;

import com.example.productmanage.DAO.ProductDAO;
import com.example.productmanage.model.Brand;
import com.example.productmanage.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static ProductService productService;
    private static BrandService brandService;
    private final ProductDAO productDAO;


    private ProductService() {
        productDAO = new ProductDAO();
        brandService = BrandService.getInstance();
    }

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public List<Product> displayProduct() {
        return productDAO.displayAll();
    }

    public void save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int brandID = Integer.parseInt(request.getParameter("brand"));
        Brand brand = brandService.getById(brandID);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (id != null) {
            int idUpdate = Integer.parseInt(id);
            productDAO.updateProduct(new Product(idUpdate, name, price, brand, quantity));
        } else {
            productDAO.addProduct(new Product(name, price, brand, quantity));
        }
    }

    public Product getById(int id) {
        return productDAO.displayById(id);
    }

    public void deleteById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteById(id);
    }

    public boolean checkById(int id) {
        Product product = productDAO.displayById(id);
        return product != null;
    }

}
