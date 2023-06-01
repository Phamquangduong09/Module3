package com.example.productmanage.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private Brand brand;
    private int quantity;


    public Product() {
    }

    public Product(int id, String name, double price, Brand brand, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
    }

    public Product(String name, double price, Brand brand, int quantity) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", brand='" + brand;
    }
}
