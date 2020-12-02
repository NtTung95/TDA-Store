package Controller.Cart;

import DAO.ProductDAO;
import Model.Product;
import Model.ProductCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Cart", urlPatterns = "/cart")
public class Cart extends HttpServlet {
    public static ArrayList<ProductCart> listProductCart = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addToCart(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProductCart",listProductCart);
request.getRequestDispatcher("cart.jsp").forward(request,response);
    }

    protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProduct = request.getParameter("IdProduct");
        int amoutSelect = Integer.parseInt(request.getParameter("amoutSelect"));
        String sizeColor = request.getParameter("sizeSelect");
            ProductCart productCart = ProductDAO.getProductDetailCart(idProduct,sizeColor,amoutSelect);
        listProductCart.add(productCart);
        response.sendRedirect("/cart");
    }
}
