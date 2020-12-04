package Controller.Admin.Orders;

import DAO.order.OrdersDAO;
import Model.orderDetailResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "orderDetail", urlPatterns = "/orderdetail")
public class orderDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderid");
        ArrayList<orderDetailResult> orderDetails = OrdersDAO.getOrderDetailInDb(orderId);
        request.setAttribute("orderDetails",orderDetails);
        request.getRequestDispatcher("/admin/orderDetail.jsp").forward(request,response);
    }
}
