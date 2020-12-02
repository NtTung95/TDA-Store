package Controller.Product;

import DAO.ConnectDB;
import DAO.ProductDAO;
import Model.Customer;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProductDetail", urlPatterns = "/productDetail")
public class ProductDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product Product = ProductDAO.getProductDetail(productId);
        request.setAttribute("productDetail", Product);
        request.getRequestDispatcher("productDetail.jsp").forward(request, response);
    }
}
