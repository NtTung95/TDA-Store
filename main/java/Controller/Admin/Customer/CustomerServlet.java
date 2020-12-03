package Controller.Admin.Customer;

import DAO.customer.CustomerDAO;
import Model.Customer;
import Model.TypeAccount;

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
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/admin/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerDAO customerDAO = new CustomerDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("edit".equals(action)) {
                updateCustomer(request, response);
            }
        } catch (IOException | SQLException ex) {
            throw new IOException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "delete":
                    deleteCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (IOException | SQLException ex) {
            throw new IOException(ex);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        int typeOfId = (int) session.getAttribute("typeOfId");
        if (typeOfId == 0){
            response.sendRedirect("/login");
        }else {
            if (typeOfId==CustomerDAO.CHECK_ADMIN){
                List<TypeAccount> typeAccounts = customerDAO.getTypeAccountList();
                List<Customer> listCustomer = customerDAO.selectAllCustomer();
                request.setAttribute("typeAccountList", typeAccounts);
                request.setAttribute("listCustomer", listCustomer);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCustomer.jsp");
                requestDispatcher.forward(request,response);
            }else {
                response.sendRedirect("/error.jsp");
            }
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<TypeAccount> typeAccounts = customerDAO.getTypeAccountList();
        request.setAttribute("typeAccountList", typeAccounts);
        int customerId = Integer.parseInt(request.getParameter("customerID"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String birthDay = request.getParameter("birthDay");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int typeAccountId = Integer.parseInt(request.getParameter("typeAccountId"));
        Customer customer = new Customer(customerId ,userName, password, firstName, surName, birthDay, phoneNumber,address,email,typeAccountId);
        customerDAO.updateCustomer(customer);

        List<Customer> listCustomer = customerDAO.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        customerDAO.deleteCustomer(customerId);

        List<Customer> listCustomer = customerDAO.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCustomer.jsp");
        dispatcher.forward(request, response);
    }
}
