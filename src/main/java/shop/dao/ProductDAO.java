package shop.dao;

import java.util.ArrayList;

/**
 * Created by Администратор on 04.04.2018.
 */
public abstract interface ProductDAO {

    public abstract ArrayList<Product> getProducts();

    public abstract ArrayList<Product> getCategoryProducts(String category);

    public abstract Product getSingleProduct(String name);

}
