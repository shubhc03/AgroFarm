package model;

public class Product {
    private String name;
    private String image;
    private double price;

    Product(int productId, String productName, String category, double price, String farmerName, String base64Image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
