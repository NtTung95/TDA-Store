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

@WebServlet(urlPatterns = {"/inforcustomer"})
public class InforCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ac = request.getParameter("action");
        if (ac == null) {
            request.getRequestDispatcher("inforCus.jsp").forward(request, response);
        } else {
            switch (ac) {
                case "oder":
                    request.getRequestDispatcher("oderHis.jsp").forward(request, response);
                    break;
                case "infor" :
                request.getRequestDispatcher("inforCus.jsp").forward(request, response);

                break;

            }
        }
    }
}
