package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.dao.DataAbstractFactory;
import shop.dao.MySqlFactory;
import shop.dao.Product;
import shop.dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Администратор on 02.04.2018.
 */

@Controller
@RequestMapping("/products")
public class ProductViewController{

    @RequestMapping
    public String postHello(HttpServletRequest req, HttpServletResponse resp){

        DataAbstractFactory dataAbstractFactory = new MySqlFactory();
        ProductDAO productDAO = dataAbstractFactory.getProductDAO();

        ArrayList<Product> products = null;

        if((req.getParameter("category")!=null)){
            products = productDAO.getCategoryProducts(req.getParameter("category"));
            req.setAttribute("products",products);
        }else{
            products = productDAO.getProducts();
            req.setAttribute("products",products);
        }

        return "productModel2";
    }

}
