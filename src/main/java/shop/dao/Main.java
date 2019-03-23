package shop.dao;

/**
 * Created by Администратор on 04.04.2018.
 */
public class Main {

    public static void main(String[] args){

        DataAbstractFactory dataAbstractFactory = new MySqlFactory();
        UserDAO userDAO = dataAbstractFactory.getUserDAO();

        userDAO.login("andrusiv@gmail.com", "3gergehd");
        //ProductDAO productDAO = dataAbstractFactory.getProductDAO();

        //System.out.println(userDAO.login("andrusiv@gmail.com"));


       // ArrayList<Product> products = productDAO.getProducts();

        //for(Product pr: products){
        //    System.out.println(pr.getName());
        //    System.out.println(" ");
        //}

    }
}
