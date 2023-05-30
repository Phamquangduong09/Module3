package com.example.productmanage.service;

import com.example.productmanage.model.Brand;
import com.example.productmanage.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManage {
    private final List<Product> productList;
    private static ProductManage productManage;

    public ProductManage() {
        productList = new ArrayList<>();
    }

    public static ProductManage getInstance() {
        if (productManage == null) {
            productManage = new ProductManage();
        }
        return productManage;
    }

    public List<Product> getProduct() {
        return productList;
    }

    public void addProduct(Product p) {
        productList.add(p);
    }

    public Product getById(String id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void deleteById(String id) {
        Product product = getById(id);
        if (product != null) {
            productList.remove(product);
        }
    }

    public void deleteByBrand(Brand b) {
        List<Product> productsDelete = new ArrayList<>();
        for (Product p : productList) {
            if (p.getBrand().equals(b)) {
                productsDelete.add(p);
            }
        }
        productList.removeAll(productsDelete);
    }
}
