package shop.dao;

import java.util.HashMap;

/**
 * Created by Администратор on 04.04.2018.
 */
public class Cart {

    int total = 0;

    HashMap<Product,Integer> cart = null;

    public Cart(){
        cart = new HashMap<>();
    }

    public HashMap<Product,Integer> getCart() {
        return cart;
    }

    public int getTotal() {
        return total;
    }

    public void addProduct(Product product, Integer amount){
        Product sameProduct = null;
        int incValue = 0;

        boolean sameProductFlag = false;
        for(Product pr : cart.keySet()){
            if(pr.getId()==product.getId()){
                sameProductFlag = true;
                sameProduct = pr;
                incValue = cart.get(sameProduct);
            }
        }

        if(sameProductFlag){
            cart.put(sameProduct, (incValue + amount.intValue()));
            total=total+amount.intValue();
        }else{
                cart.put(product, amount.intValue());
                total=total+amount.intValue();
        }


    }

    public void delProduct(Product product, Integer amount){
        Product sameProduct = null;
        int incValue = 0;

        boolean sameProductFlag = false;
        for(Product pr : cart.keySet()){
            if(pr.getId()==product.getId()){
                sameProductFlag = true;
                sameProduct = pr;
                incValue = cart.get(sameProduct);
            }
        }

        if(sameProductFlag){
            if(incValue<=amount){
                cart.remove(sameProduct);
            }else{
                cart.put(sameProduct, (incValue-amount.intValue()));
                total=total-amount.intValue();
            }
        }

    }

}
