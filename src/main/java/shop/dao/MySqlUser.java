package shop.dao;



import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class MySqlUser implements UserDAO {

    Connection conn = null;

    public MySqlUser(Connection connection){
        conn=connection;
    }


    @Override
    public User login(String login, String password) {

        String result = null;
        User user = null;
        try {
            Statement st = conn.createStatement();

            String sql = "SELECT * FROM users WHERE email='"+login+"' AND password='"+encript(password)+"' ";

            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                //result = rs.getString("name");
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(password);
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setArea(rs.getString("area"));
                user.setComment(rs.getString("comment"));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return user;

    }

    public String encript(String password){
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(password));
            System.out.println(String.format("%032x", new BigInteger(md5.digest())));
            System.out.println(1234344);
            return String.format("%032x", new BigInteger(md5.digest()));
        } catch (NoSuchAlgorithmException e ){
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void insertUser(String login, String password, String name, String gender, String area, String comment) {
        String sql = "INSERT INTO users (email,password,name,gender,area,comment) VALUES('"+login+"','"+encript(password)+"','"+name+"','"+gender+"','"+area+"','"+comment+"')";

        try {
            Statement st = conn.createStatement();

            st.execute(sql);

            st.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET email = ?, password = ?, name = ?, gender = ?, area = ?, comment = ? WHERE id = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,user.getEmail());
            ps.setString(2,encript(user.getPassword()));
            ps.setString(3,user.getName());
            ps.setString(4,user.getGender());
            ps.setString(5,user.getArea());
            ps.setString(6,user.getComment());
            ps.setInt(7,user.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
