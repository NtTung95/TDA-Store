package Controller.Customer;

import DAO.customer.CustomerDAO;
import Model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO us = new CustomerDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer customer = CustomerDAO.getInfoLogin(username,password);
        HttpSession session = request.getSession();
        session.setAttribute("nullCustomer",customer);
        if(us.checkLogin(username,password)) {
            session.setAttribute("loggedCustomer", customer);
            session.setAttribute("nameLogin",username);
            session.setAttribute("typeOfId",customer.getTypeAccountId());
            response.sendRedirect("/homepage");
        } else {
            request.setAttribute("messages", "*Your username or password is wrong! Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
