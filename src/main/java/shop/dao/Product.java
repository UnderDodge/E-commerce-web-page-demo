package shop.dao;

/**
 * Created by Администратор on 02.04.2018.
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private String category;
    private int br;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBr() {
        return br;
    }

    public void setBr(int br) {
        this.br = br;
    }
}
