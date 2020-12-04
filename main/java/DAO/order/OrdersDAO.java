package DAO.order;

import DAO.ConnectDB;
import Model.Order;
import Model.Product;
import Model.orderDetailResult;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDAO {
    public static ArrayList<Order> getOrdersInDb() {
        Connection conn = null;
        ArrayList<Order> orders = new ArrayList<>();

        try {
            conn = ConnectDB.connectionDB();
            String query = "select * from orders";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    Order order = new Order();
                    order.setOrderId(rs.getString("orderId"));
                    order.setCustomerId(rs.getString("customerID"));
                    order.setDateOrdered(String.valueOf(rs.getDate("dateOrdered")));
                    order.setStatus(rs.getString("status"));
                    orders.add(order);
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return orders;
    }
    public static ArrayList<Order> getOrdersInDbById(int idCustomer) {
        Connection conn = null;
        ArrayList<Order> orders = new ArrayList<>();

        try {
            conn = ConnectDB.connectionDB();
            String query = "select * from orders where customerID = ?";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setInt(1,idCustomer);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    Order order = new Order();
                    order.setOrderId(rs.getString("orderId"));
                    order.setCustomerId(rs.getString("customerID"));
                    order.setDateOrdered(String.valueOf(rs.getDate("dateOrdered")));
                    order.setStatus(rs.getString("status"));
                    orders.add(order);
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return orders;
    }
    public static ArrayList<orderDetailResult> getOrderDetailInDb(String orderID) {
        Connection conn = null;
        ArrayList<orderDetailResult> orderDetailResultsArray = new ArrayList<>();

        try {
            conn = ConnectDB.connectionDB();
            String query = "select * from orderhistory_view where orderId = ?";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, orderID);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    orderDetailResult orderDetailResult = new orderDetailResult();
                    orderDetailResult.setCustomerID(String.valueOf(rs.getInt("customerID")));
                    orderDetailResult.setOrderId(String.valueOf(rs.getInt("orderId")));
                    orderDetailResult.setProductName(rs.getString("productName"));
                    orderDetailResult.setPrice(String.valueOf(rs.getInt("price")));
                    orderDetailResult.setQuantity(String.valueOf(rs.getInt("quantity")));
                    orderDetailResult.setDateOrdered(String.valueOf(rs.getDate("dateOrdered")));
                    orderDetailResultsArray.add(orderDetailResult);
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return orderDetailResultsArray;
    }

}
