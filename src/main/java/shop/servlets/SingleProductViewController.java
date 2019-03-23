package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dao.DataAbstractFactory;
import shop.dao.MySqlFactory;
import shop.dao.Product;
import shop.dao.ProductDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Администратор on 04.04.2018.
 */

@Controller
@RequestMapping("/singleProduct")
public class SingleProductViewController {

    @RequestMapping
    public String doPost(HttpServletRequest req, HttpServletResponse resp) {

        DataAbstractFactory dataAbstractFactory = new MySqlFactory();
        ProductDAO productDAO = dataAbstractFactory.getProductDAO();

        Product product = null;

        if((req.getParameter("id")!=null)){
            product = productDAO.getSingleProduct(req.getParameter("id"));
            req.setAttribute("product",product);
            System.out.println(product.getName());
        }
        return "singleProduct";
    }


}
