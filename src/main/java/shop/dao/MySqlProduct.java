package shop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Администратор on 04.04.2018.
 */
public class MySqlProduct implements ProductDAO {

    private Connection conn;

    public MySqlProduct(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Product> getProducts() {

        ArrayList<Product> products =  new ArrayList<>();
        Product product = null;
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM products";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                //result = rs.getString("name");
                product =  new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setBr(rs.getInt("br"));
                products.add(product);
                product = null;
                //System.out.println(1);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return products;
    }

    @Override
    public ArrayList<Product> getCategoryProducts(String category) {

        ArrayList<Product> products =  new ArrayList<>();
        Product product = null;
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM products WHERE category='"+category+"' ";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                //result = rs.getString("name");
                product =  new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setBr(rs.getInt("br"));
                products.add(product);
                product = null;
                //System.out.println(1);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return products;
    }

    @Override
    public Product getSingleProduct(String id) {

        Product product = null;
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM products WHERE id='"+id+"' ";
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                //result = rs.getString("name");
                product =  new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setBr(rs.getInt("br"));
                //System.out.println(1);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return product;
    }

}
