package DAO.order;

import Model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
        void insertUser(Order order) throws SQLException;

        Order selectOrder(int id);

        List<Order> selectAllOrder();

        boolean deleteOrder(int id) throws SQLException;

        boolean updateOrder(Order order) throws SQLException;

}
