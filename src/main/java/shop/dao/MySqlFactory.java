package shop.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Администратор on 04.04.2018.
 */
public class MySqlFactory extends DataAbstractFactory {

    private java.sql.Connection conn;

    private Xml xml = new Xml();

    public MySqlFactory(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver loaded");
            //System.out.println(xml.getConfig());
            conn = DriverManager.getConnection(xml.getConfig());
            System.out.println("Connection Created");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySqlUser(conn);
    }

    @Override
    public ProductDAO getProductDAO() {
        return new MySqlProduct(conn);
    }
}
