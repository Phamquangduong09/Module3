package com.example.productmanage.DAO;

import com.example.productmanage.model.Cart;
import com.example.productmanage.model.Product;
import com.example.productmanage.service.ProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    private final String SELECT_ALL = "SELECT * FROM cart;";
    private final String SELECT_BY_ID = "select * from cart where id = ?;";
    private final String INSERT_INTO = "insert into cart(quantity,id_product) values (?,?)";
    private final String UPDATE_BY_ID = "update cart set  quantity = ?,product_id = ? where id = ?";
    private final String DELETE_BY_ID = "delete from cart where id = ?";
    private final String UPDATE_QUANTITY = "update cart set quantity = quantity + ? where id = ?";
    private final String TOTAL_PRICE = "select sum(price * cart.quantity) as total_price from cart join product p on p.id = cart.id_product;";

    private Connection connection = MyConnection.getConnection();
    private static CartDAO cartDAO;

    public static CartDAO getInstance() {
        if (cartDAO == null) {
            cartDAO = new CartDAO();
        }
        return cartDAO;
    }

    public List<Cart> displayAll() {
        List<Cart> cartList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int productId = resultSet.getInt("id_product");
                Product product = ProductService.getInstance().getById(productId);
                int quantity = resultSet.getInt("quantity");
                cartList.add(new Cart(id, quantity, product));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }

    public Cart displayById(int id) {
        Cart cart = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                Product product = ProductService.getInstance().getById(productId);
                int quantity = resultSet.getInt("quantity");
                cart = new Cart(id, quantity, product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cart;
    }

    public void addCart(Cart cart) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, cart.getQuantity());
            preparedStatement.setInt(2, cart.getProduct().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public void updateCart(Cart cart) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
//            preparedStatement.setInt(1, cart.getProduct().getId());
//            preparedStatement.setInt(2, cart.getQuantity());
//            preparedStatement.setInt(3, cart.getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(TOTAL_PRICE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                totalPrice = resultSet.getDouble("total_price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public void updateCartQuantity(int id, int quantity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
