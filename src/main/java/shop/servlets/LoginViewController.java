package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dao.DataAbstractFactory;
import shop.dao.MySqlFactory;
import shop.dao.User;
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
 * Created by Администратор on 26.03.2018.
 */

@Controller
@RequestMapping("/login")
public class LoginViewController {

    @RequestMapping
    protected String doPost(HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();

        String logout = req.getParameter("logout");
        //out.write("got logout parameter");
        if(logout!=null){
            session.invalidate();
            session = req.getSession(true);
            //out.write("new session! (logout stuff)");
        }
        //out.write("2");
        boolean flag = false;

        String access = "";

        String login = req.getParameter("login");
        String pass = req.getParameter("pas");
       // out.write("3");
        User user = null;


        //out.write("4");
        if(login!=null){
            DataAbstractFactory dataAbstractFactory = new MySqlFactory();
            UserDAO userDAO = dataAbstractFactory.getUserDAO();

            user = userDAO.login(login, pass);
            //out.write("5");
            if (user != null) {
                //out.write("hey user is created!");
                session.setAttribute("user", user);
                flag=false;
                //resp.sendRedirect("/success?login=UnderDodge");
            } else {
                access="<h3 align='center' style='color:red'>Access denied</h3>";
                flag=true;
                //out.write("wrong pass");
                //resp.sendRedirect("/denied");
            }
        }else{
            //out.write("6");
            flag=false;
        }

        return "index";
    }


}
