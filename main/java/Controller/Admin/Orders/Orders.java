package Controller.Admin.Orders;

import DAO.order.OrdersDAO;
import Model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Orders",urlPatterns = "/admin/orders")
public class Orders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orders = OrdersDAO.getOrdersInDb();
        request.setAttribute("orderList",orders);
        request.getRequestDispatcher("ordersList.jsp").forward(request,response);
    }
}
