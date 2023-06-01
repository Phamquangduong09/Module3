package com.example.productmanage.service;

import com.example.productmanage.DAO.BrandDAO;
import com.example.productmanage.model.Brand;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BrandService {
    private final BrandDAO brandDAO;
    private static BrandService brandService;

    private BrandService() {
        brandDAO = new BrandDAO();
    }

    public static BrandService getInstance() {
        if (brandService == null) {
            brandService = new BrandService();
        }
        return brandService;
    }

    public List<Brand> displayAll() {
        return brandDAO.displayAll();
    }

    public void save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        if (id != null) {
            int idUpdate = Integer.parseInt(id);
            brandDAO.updateBrand(new Brand(idUpdate, name));
        } else {
            brandDAO.addBrand(new Brand(name));
        }
    }

    public void deleteById(int id) {
        brandDAO.deleteById(id);
    }

    public Brand getById(int id) {
        return brandDAO.displayById(id);
    }


    public boolean checkById(int id) {
        Brand brand =brandService.getById(id);
        return brand != null;
    }
}
