package com.example.productmanage.DAO;

import com.example.productmanage.model.Brand;
import com.example.productmanage.model.Product;
import com.example.productmanage.service.BrandService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final Connection connection;

    private final BrandService brandService = BrandService.getInstance();

    private final String SELECT_ALL = "select * from product;";
    private final String SELECT_BY_ID = "select * from product where id = ?;";
    private final String INSERT_INTO = "insert into product(name,price,brand,quantity) value (?,?,?,?);";
    private final String UPDATE_BY_ID = "update product set name = ? ,  price = ? ,  brand = ?, quantity = 2 where id = ?;";
    private final String DELETE_BY_ID = "delete from product where id = ?";

    public ProductDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Product> displayAll() {
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int brand1 = resultSet.getInt("brand");
                Brand brand = brandService.getById(brand1);
                int quantity = resultSet.getInt("quantity");
                Product p = new Product(id, name, price, brand, quantity);
                productList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    public void addProduct(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getBrand().getId());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getBrand().getId());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product displayById(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int brandID = resultSet.getInt("brand");
                Brand brand = brandService.getById(brandID);
                int quantity = resultSet.getInt("quantity");
                product = new Product(id, name,price,brand,quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
