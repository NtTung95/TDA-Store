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

        if(us.checkLogin(username,password)) {
            HttpSession session = request.getSession();
            Customer customer = CustomerDAO.getInfoLogin(username,password);
            session.setAttribute("nameLogin",username);
            session.setAttribute("typeOfId",customer.getTypeAccountId());
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
//            response.sendRedirect("/login.jsp");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
