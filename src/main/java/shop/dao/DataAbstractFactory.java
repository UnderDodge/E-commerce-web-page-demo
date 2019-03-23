package shop.dao;

/**
 * Created by Администратор on 04.04.2018.
 */
public abstract class DataAbstractFactory {

    public DataAbstractFactory(){

    }


    public static DataAbstractFactory getFactory(String source){
        switch(source){
            case "mysql":
                return new MySqlFactory();
            default:
                return null;
        }


    }

    public abstract UserDAO getUserDAO();

    public abstract ProductDAO getProductDAO();
}
