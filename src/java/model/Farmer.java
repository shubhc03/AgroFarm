package model;

import java.util.List;

public class Farmer {
    private int id;
    private String name;
    private String location;
    private String shopImage;
    private List<Product> products;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getShopImage() { return shopImage; }
    public void setShopImage(String shopImage) { this.shopImage = shopImage; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
