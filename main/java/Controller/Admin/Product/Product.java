package Controller.Admin.Product;

import DAO.ProductDAO;
import Model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Product", urlPatterns = "/admin/product")
public class Product extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = (String) request.getParameter("action");
        switch (action) {
            case "update":
                updateProduct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Model.Product> products = ProductDAO.getProductInDb();
        request.setAttribute("listProduct", products);

        ArrayList<Category> categories = ProductDAO.loadCategory();
        request.setAttribute("listCategory", categories);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/product.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String categoryProduct = request.getParameter("categoryProduct");
        String quantityProduct = request.getParameter("quantityProduct");
        String priceProduct = request.getParameter("priceProduct");
        String descriptionProduct = request.getParameter("descriptionProdut");
        String imgMainProduct = request.getParameter("imgMainProduct");
        String img1Product = request.getParameter("img1Product");
        String img2Product = request.getParameter("img2Product");
        String img3Product = request.getParameter("img3Product");
        String img4Product = request.getParameter("img4Product");
        String SizeSProduct = request.getParameter("SizeSProduct");
        String SizeMProduct = request.getParameter("SizeMProduct");
        String SizeLProduct = request.getParameter("SizeLProduct");
        String SizeXLProduct = request.getParameter("SizeXLProduct");
        String SizeXXLProduct = request.getParameter("SizeXXLProduct");
        boolean isValid = ProductDAO.EditProduct(ProductId,categoryProduct,quantityProduct,priceProduct,descriptionProduct,productName,imgMainProduct,img1Product,img2Product,img3Product,img4Product,SizeSProduct,SizeMProduct,SizeLProduct,SizeXLProduct,SizeXXLProduct);
        if (isValid){
            response.sendRedirect("/admin/product");
        }
    }
    protected void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String categoryProduct = request.getParameter("categoryProduct");
        String quantityProduct = request.getParameter("quantityProduct");
        String priceProduct = request.getParameter("priceProduct");
        String descriptionProduct = request.getParameter("descriptionProdut");
        String imgMainProduct = request.getParameter("imgMainProduct");
        String img1Product = request.getParameter("img1Product");
        String img2Product = request.getParameter("img2Product");
        String img3Product = request.getParameter("img3Product");
        String img4Product = request.getParameter("img4Product");
        String SizeSProduct = request.getParameter("SizeSProduct");
        String SizeMProduct = request.getParameter("SizeMProduct");
        String SizeLProduct = request.getParameter("SizeLProduct");
        String SizeXLProduct = request.getParameter("SizeXLProduct");
        String SizeXXLProduct = request.getParameter("SizeXXLProduct");
        boolean isValid = ProductDAO.EditProduct(ProductId,categoryProduct,quantityProduct,priceProduct,descriptionProduct,productName,imgMainProduct,img1Product,img2Product,img3Product,img4Product,SizeSProduct,SizeMProduct,SizeLProduct,SizeXLProduct,SizeXXLProduct);
        if (isValid){
            response.sendRedirect("/admin/product");
        }
    }
}
