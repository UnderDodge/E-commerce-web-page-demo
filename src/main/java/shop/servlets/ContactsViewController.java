package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Администратор on 25.04.2018.
 */

@Controller
@RequestMapping(value = "/contacts")
public class ContactsViewController {

    @RequestMapping
    public String getPost(HttpServletRequest req, HttpServletResponse resp){
        return "contacts";
    }

}
