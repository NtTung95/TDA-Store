package DAO.order;

import DAO.ConnectDB;
import Model.Product;
import Model.ProductCart;

import java.sql.*;
import java.util.ArrayList;

public class CheckoutDAO {
    public static void insertOrders(ArrayList<ProductCart> productCarts, int idCustomer) {
        Connection conn = null;


        try {
            conn = ConnectDB.connectionDB();
            String query = "insert into orders(customerID,dateOrdered) values (?,NOW())";
            String query2 = "insert into orderdetail(orderId, productId, quantity) VALUES (LAST_INSERT_ID(),?,?)";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                PreparedStatement pre2 = conn.prepareStatement(query2);


                pre.setInt(1,idCustomer);
                int rs = pre.executeUpdate();
                for (ProductCart productCart:productCarts) {
                    pre2.setInt(1,productCart.getProductId());
                    pre2.setInt(2,1);
                    int rs2 = pre2.executeUpdate();
                }


//                while (rs.next()) {
//
//                }
//                while (rs2.next()) {
//
//                }


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

    }
}
