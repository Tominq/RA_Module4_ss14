package ra.ss14.model;

public class Product {
    private int id;
    private String name;
    private String imageUrl;
    private double price;
    private String desc;
    private int stock;
    private boolean status = true;

    public Product() {
    }

    public Product(String name, String imageUrl, double price, String desc, int stock) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
    }



    public Product(int id, String name, String imageUrl, double price, String desc, int stock, boolean status) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
        this.status = status;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
