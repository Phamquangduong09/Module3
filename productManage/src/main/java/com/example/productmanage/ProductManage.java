package com.example.productmanage;

import java.util.ArrayList;
import java.util.List;

public class ProductManage {
    private final List<Product> productList;
    private static ProductManage productManage;

    public ProductManage() {
        productList = new ArrayList<>();
        productList.add(new Product("Iphone 14", 1200, new Brand("Apple"), "Gold", "new"));
        productList.add(new Product("SamSung s20 ultra", 1100, new Brand("SamSung"), "Pink", "new"));
        productList.add(new Product("Oppo reno 8", 900, new Brand("Oppo"), "White", "new"));
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
