package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dao.Cart;
import shop.dao.DataAbstractFactory;
import shop.dao.MySqlFactory;
import shop.dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Администратор on 04.04.2018.
 */

@Controller
@RequestMapping("/productsCart")
public class CartViewController {


    @RequestMapping
    public String doPost(HttpServletRequest req, HttpServletResponse resp)  {
        DataAbstractFactory dataAbstractFactory = new MySqlFactory();
        ProductDAO productDAO = dataAbstractFactory.getProductDAO();

        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher = null;
        Cart cart = null;
        if(req.getParameter("show")==null){
            System.out.println("WORKED!");
            if(session.getAttribute("cart")==null){
                cart = new Cart();
                cart.addProduct(productDAO.getSingleProduct(req.getParameter("buy")), Integer.valueOf(req.getParameter("amount")));
                System.out.println("Created and Added to the cart");
                session.setAttribute("cart", cart);
                return "/productModel2";
            }else{
                if(req.getParameter("del")!=null){
                    cart = (Cart) session.getAttribute("cart");
                    cart.delProduct(productDAO.getSingleProduct(req.getParameter("del")), Integer.valueOf(req.getParameter("amount")));
                    System.out.println("Deleted from cart");
                    session.setAttribute("cart", cart);
                    return "/cart";
                }else{
                    cart = (Cart) session.getAttribute("cart");
                    cart.addProduct(productDAO.getSingleProduct(req.getParameter("buy")), Integer.valueOf(req.getParameter("amount")));
                    System.out.println("Added to existing cart");
                    session.setAttribute("cart", cart);
                    return "/productModel2";
                }
            }
        }else{
            System.out.println("Nothing!");
            return "/cart";
        }
    }
}
