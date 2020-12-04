package Controller.Checkout;

import DAO.order.CheckoutDAO;
import Model.ProductCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static Controller.Cart.Cart.Amout;
import static Controller.Cart.Cart.listProductCart;

@WebServlet(name = "Checkout", urlPatterns = "/checkout")
public class Checkout extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idCustomer=0;
        if (session.getAttribute("idCustomer") == null){
            response.sendRedirect("/login");
        }else {
            if (listProductCart.size() <= 0){
                response.sendRedirect("/homepage");
            }
            idCustomer =(int) session.getAttribute("idCustomer");
            CheckoutDAO.insertOrders(listProductCart, idCustomer);
            listProductCart = new ArrayList<>();
            Amout = 0;
            request.getRequestDispatcher("/paymentOk.jsp").forward(request,response);
        }
    }
}
