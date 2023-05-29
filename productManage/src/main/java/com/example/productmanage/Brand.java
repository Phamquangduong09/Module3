package com.example.productmanage;

public class Brand {
    private int id ;
    private static int idUp = 1;
    private String name ;

    public Brand() {
    }

    public Brand(String name) {
        this.id = idUp++;
        this.name = name;
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

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
