package Controller.Customer;

import DAO.customer.CustomerDAO;
import Model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/inforcustomer"})
public class InforCustomer extends HttpServlet {

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
            request.getRequestDispatcher("inforCustomer.jsp").forward(request, response);
        } else {
            switch (action) {
                case "oder":
                    request.getRequestDispatcher("odrerHistory.jsp").forward(request, response);
                    break;
                case "infor":
                    request.getRequestDispatcher("inforCustomer.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);

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
}
