package com.example.productmanage;

public class Product {
    private String id;

    private static int idUp = 1;


    private String name;


    private double price;


    private Brand brand;

    private String color;

    private String describe;


    public Product() {
    }

    public Product(String name, double price, Brand brand, String color, String describe) {
        this.id = "MS" + idUp++;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getIdUp() {
        return idUp;
    }

    public static void setIdUp(int idUp) {
        Product.idUp = idUp;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", color='" + color + ", describe=" + describe;
    }
}
