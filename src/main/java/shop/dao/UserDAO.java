package shop.dao;

/**
 * Created by Администратор on 05.03.2018.
 */
public interface UserDAO {
    public User login(String login, String password);
    public void insertUser(String login, String password, String name, String gender, String area, String comment);
    public void updateUser(User user);
    //public String encript(String password);
}
