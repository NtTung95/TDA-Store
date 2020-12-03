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

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories = ProductDAO.loadCategory();
        request.setAttribute("categoryList", categories);
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "search":
                searchProduct(request,response);
                break;
            default:
                resultProduct(request,response);
                break;
        }


    }

    protected void resultProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("category");
        if (categoryId == null) {
            ArrayList<Product> products = ProductDAO.getProductInDb();
            request.setAttribute("listProduct", products);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else {
            ArrayList<Product> productsByCate = ProductDAO.getProductByCate(categoryId);
            request.setAttribute("listProduct", productsByCate);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        }
    }

    protected void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = "%"+request.getParameter("search")+"%";
        if (search != null){
            ArrayList<Product> productsSearch = ProductDAO.findProduct(search);
            request.setAttribute("listProduct", productsSearch);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        }
    }
}
