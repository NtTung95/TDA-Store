package Controller.Product;

import DAO.ProductDAO;
import Model.Category;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories = ProductDAO.loadCategory();
        request.setAttribute("categoryList", categories);

        ArrayList<Product> products = ProductDAO.getProductInDb();
        request.setAttribute("listProduct", products);

        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}
