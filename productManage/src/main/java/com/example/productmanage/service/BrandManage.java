package com.example.productmanage.service;

import com.example.productmanage.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandManage {
    private List<Brand> brandList;
    private static BrandManage brandManage;

    private BrandManage() {
        brandList = new ArrayList<>();
        brandList.add(new Brand("Apple"));
        brandList.add(new Brand("SamSung"));
        brandList.add(new Brand("Oppo"));
    }

    public static BrandManage getInstance() {
        if (brandManage == null) {
            brandManage = new BrandManage();
        }
        return brandManage;
    }

    public List<Brand> getBrand() {
        return brandList;
    }

    public Brand getBrandById(int id) {
        for (Brand brand : brandList) {
            if (brand.getId() == id) {
                return brand;
            }
        }
        return null;
    }

    public Brand getBrandByName(String name) {
        for (Brand brand : brandList) {
            if (brand.getName().equals(name)) {
                return brand;
            }
        }
        return null;
    }

    public void addBrand(Brand b) {
        brandList.add(b);
    }

    public Brand getById(int id) {
        for (Brand b : brandList) {
            if (b.getId()== id) {
                return b;
            }
        }
        return null;
    }

    public void deleteById(int id) {
      Brand brand = getById(id);
        if (brand != null) {
            brandList.remove(brand);
        }
    }

}
