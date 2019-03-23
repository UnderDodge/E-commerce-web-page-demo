package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dao.DataAbstractFactory;
import shop.dao.MySqlFactory;
import shop.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Администратор on 16.04.2018.
 */

@Controller
@RequestMapping("/registration")
public class RegistrationViewController {


    @RequestMapping
    protected String doPost(HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();

        RequestDispatcher requestDispatcher = null;

        boolean error = false;
        boolean error1 = false;
        boolean textFlag = false;


            RegValidation rv = new RegValidation();

            StringBuilder errorText = new StringBuilder("<ul style='color:red'>");


            String[] ids = {"login", "pas1", "pas2", "name", "gender", "area", "comment"};

            String login = req.getParameter("login");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String comment = req.getParameter("comment");
            String password = req.getParameter("pas1");
            String area = req.getParameter("area");


            for (String str : ids) {
                if (req.getParameter(str) != null) {
                    error1 = true;
                }
            }

            if (error1) {
                for (String str : ids) {
                    if (req.getParameter(str) == null) {
                        error = true;
                        errorText.append("<li>Please enter your " + str + "</li>");
                        textFlag=true;
                    }
                }
                if (!error) {

                    if (rv.emailValidation(req.getParameter("login")) == true) {
                        if (rv.passwordValidation(req.getParameter("pas1")) == true) {
                            if (req.getParameter("pas1").equals(req.getParameter("pas2"))) {
                                req.setAttribute("reg", "name");
                                DataAbstractFactory dataAbstractFactory = new MySqlFactory();
                                UserDAO userDAO = dataAbstractFactory.getUserDAO();
                                userDAO.insertUser(login, password, name, gender, area, comment);
                            } else {
                                errorText.append("<li>Passwords does not match</li>");
                                textFlag=true;
                            }
                        } else {
                            errorText.append("<li>Password does not meet requirements.</li> <li>Password must be 8 characters or more and include charecters AND numbers.</li>");
                            textFlag=true;
                        }
                    } else {
                        errorText.append("<li>Entered email is not valid</li>");
                        textFlag=true;
                    }
                }
            }
            errorText.append("</ul>");

            if(textFlag){
                req.setAttribute("error", errorText.toString());
            }

        return "registration";

    }

}
