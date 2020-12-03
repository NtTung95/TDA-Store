package DAO.order;

import DAO.ConnectDB;
import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO implements IOrderDAO {
    private static final String INSERT_ORDER = "INSERT INTO orders(customerID, dateOrder, dateRe, status) VALUES ( ?, ?, ?, ?);";

    private static final String SELECT_ORDER_BY_ID = "select * from orders where customerID = ?;";
    private static final String SELECT_ALL_ORDER = "select * from orders;";
    private static final String DELETE_ORDER = "delete from orders where orderId = ?;";
    private static final String UPDATE_ORDER = "update orders set dateOrdered= ?, dateRequired = ?, status = ? where customerID = ?;";
    private static final String CHECK_LOGIN = "select * from orders where userName = ? and password = ?";
    public static final int CHECK_ADMIN = 10001;
    @Override
    public void insertUser(Order order) throws SQLException {
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) {

            preparedStatement.setInt(1, order.getCustomerId());
            preparedStatement.setString(2, order.getDateOrder());
            preparedStatement.setString(3, order.getDateRequired());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {

        }
    }

    @Override
    public Order selectOrder(int customerId) {
        Order order = null;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
            preparedStatement.setInt(1,customerId );
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                String dateO = rs.getString("dateOrdered");
                String dateR = rs.getString("dateRequired");
                String status = rs.getString("status");

                order = new Order(orderId,customerId,dateO,dateR,status);
            }
        } catch (Exception e) {

        }
        return order;
    }

    @Override
    public ArrayList<Order> selectAllOrder() {
        ArrayList<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int customerId = rs.getInt("customerID");
                String dateO = rs.getString("dateOrdered");
                String dateR = rs.getString("dateRequired");
                String status = rs.getString("status");

                orders.add( new Order(orderId,customerId,dateO,dateR,status));
            }
        } catch (Exception e) {

        }
        return orders;
    }

    @Override
    public boolean deleteOrder(int customerId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER);) {
            statement.setInt(1, customerId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER);) {
            statement.setString(1, order.getDateOrder());
            statement.setString(2, order.getDateRequired());
            statement.setString(1, order.getStatus());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
