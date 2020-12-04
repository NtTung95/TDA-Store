package Controller.Customer;

import DAO.ProductDAO;
import DAO.customer.CustomerDAO;
import DAO.order.HistoryOrderDAO;
import DAO.order.OrdersDAO;
import Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/inforcustomer"})
public class InforCustomerSv extends HttpServlet {

    private CustomerDAO customerDAO = new CustomerDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            update(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            readInfor(request, response);
        } else {
            switch (action) {
                case "oder":
                    readHistoryOrder(request, response);
                    break;
                case "infor":
                    readInfor(request, response);
            }
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String userName = request.getParameter("userName");
        String pw = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String birthDay = request.getParameter("birthDay");
        String phone = request.getParameter("phoneNumber");
        int id = Integer.parseInt(request.getParameter("id"));
        int typeAccountId = Integer.parseInt(request.getParameter("typeAccountId"));
        Customer customer = new Customer(id, userName, pw, firstName, surname, birthDay, phone, address, email, typeAccountId);
        customerDAO.updateCustomer(customer);
        try {
            response.sendRedirect("homepage");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readInfor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("loggedCustomer");
        String userName = (String) session.getAttribute("nameLogin");
        if (session.getAttribute("nullCustomer") == null) {
            response.sendRedirect("/login");
        } else {
            if (userName.equals(customer.getUsername())) {

                request.setAttribute("customer", customer);
                ArrayList<Category> categories = ProductDAO.loadCategory();
                request.setAttribute("categoryList", categories);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("inforCustomer.jsp");
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect("/error.jsp");
            }
        }
    }

    public void readHistoryOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("loggedCustomer");
        int idCustomer = customer.getCustomerID();
        HistoryOrderDAO historyOrderDAO = new HistoryOrderDAO();
        ArrayList<Order> orderDetailResults = OrdersDAO.getOrdersInDbById(idCustomer);
        request.setAttribute("historyOrder", orderDetailResults);
        try {
            request.getRequestDispatcher("odrerHistory.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
