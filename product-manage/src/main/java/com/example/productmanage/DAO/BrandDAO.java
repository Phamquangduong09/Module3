package com.example.productmanage.DAO;

import com.example.productmanage.model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {

    private final Connection connection;

    private final String SELECT_ALL = "select * from brand;";
    private final String SELECT_BY_ID = "select * from brand where id = ?;";
    private final String INSERT_INTO = "insert into brand(name) value (?);";
    private final String UPDATE_BY_ID = "update brand set name = ?  where id = ?;";
    private final String DELETE_BY_ID = "delete from brand where id = ?";

    public BrandDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Brand> displayAll() {
        List<Brand> brandList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Brand brand = new Brand(id, name);
                brandList.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandList;
    }

    public void addBrand(Brand brand) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, brand.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBrand(Brand brand) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setLong(2, brand.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Brand displayById(int id) {
        Brand brand = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                brand = new Brand(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }
}
