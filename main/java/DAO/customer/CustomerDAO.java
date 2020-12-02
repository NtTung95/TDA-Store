package DAO.customer;


import DAO.ConnectDB;
import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO.customer.ICustomerDAO {
    private static final String INSERT_CUSTOMER = "INSERT INTO customer(userName, password, firstName, surName, birthDay, phoneNumber, address, email, typeAccountID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select userName, password, firstName, surName, birthDay, phoneNumber, address, email from users where customerID = ?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER = "delete from customer where customerID = ?;";
    private static final String UPDATE_CUSTOMER = "update customer set userName = ?, password = ?, firstName = ?, surName = ?, birthDay = ?, phoneNumber, address = ?, email= ?, typeAccountID = ? where userID = ?;";
    private static final String CHECK_LOGIN = "select * from customer where userName = ? and password = ?";

    @Override
    public void insertUser(Customer customer) throws SQLException {
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)) {

            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getFirstname());
            preparedStatement.setString(4, customer.getSurname());
            preparedStatement.setString(5, customer.getBirthDay());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setInt(9, customer.getTypeAccountId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Customer selectCustomer(int customerId) {
        Customer customer = null;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String surName = rs.getString("surName");
                String birthDay = rs.getString("birthDay");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int typeAccountId = Integer.parseInt(rs.getString("typeAccountId"));

                customer = new Customer(userName, password, firstName, surName, birthDay, phoneNumber,address,email,typeAccountId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int customerID = rs.getInt("customerID");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String surName = rs.getString("surName");
                String birthDay = rs.getString("birthDay");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int typeAccountId = rs.getInt("typeAccountId");
                customers.add(new Customer(customerID ,userName, password, firstName, surName, birthDay, phoneNumber,address,email,typeAccountId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int customerId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER);) {
            statement.setInt(1, customerId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER)) {
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getFirstname());
            statement.setString(4, customer.getSurname());
            statement.setString(5, customer.getBirthDay());
            statement.setString(6, customer.getPhoneNumber());
            statement.setString(7, customer.getAddress());
            statement.setString(8, customer.getEmail());
            statement.setInt(9, customer.getTypeAccountId());
            statement.setInt(10, customer.getCustomerID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        boolean isLogin = false;
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement statement = connection.prepareStatement(CHECK_LOGIN)) {
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String user = rs.getString("userName");
                String pw = rs.getString("password");
                if(user.equals(userName) && pw.equals(password)){
                    isLogin = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isLogin;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
