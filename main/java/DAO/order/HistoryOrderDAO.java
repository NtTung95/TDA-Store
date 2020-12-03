package DAO.order;

import DAO.ConnectDB;
import Model.HistoryOrders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HistoryOrderDAO {
    private static final String SELECT_ALL_ORDERHISTORY = "select orderId,productName,price,dateOrdered from orderhistory_view where customerID =?;";
    public ArrayList<HistoryOrders> selectAllOrder(int customerId) {
        ArrayList<HistoryOrders> historyOrdersList  = new ArrayList<>();
        try (Connection connection = ConnectDB.connectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERHISTORY)) {
            preparedStatement.setInt(1,customerId );
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("orderId");;
                int quantity = 1;
                String dateO = rs.getString("dateOrdered");
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                historyOrdersList.add( new HistoryOrders(orderId,customerId,quantity,productName,dateO,price));
            }
        } catch (Exception e) {

        }
        return historyOrdersList;
    }
}
