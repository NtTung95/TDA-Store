package Controller.Admin.Orders;

import DAO.customer.CustomerDAO;
import DAO.order.OrdersDAO;
import Model.Customer;
import Model.Order;
import Model.TypeAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Orders",urlPatterns = "/admin/orders")
public class Orders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("nullCustomer") == null){
            response.sendRedirect("/login");
        }else {
            if ((int) session.getAttribute("typeOfId")== CustomerDAO.CHECK_ADMIN){
                ArrayList<Order> orders = OrdersDAO.getOrdersInDb();
                request.setAttribute("orderList",orders);
                request.getRequestDispatcher("ordersList.jsp").forward(request,response);
            }else {
                response.sendRedirect("/error.jsp");
            }
        }
    }
}
