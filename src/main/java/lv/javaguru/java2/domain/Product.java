package lv.javaguru.java2.domain;

public class Product {
    private int id;
    private String name;
    private String description;
    private long price;

    public Product(int id, String name, String description, long price) {
        this(name, description, price);
        setId(id);
    }

    public Product(String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDisplayPrice() {
        return String.valueOf((double) getPrice() * 0.01);
    }

    public String toString(){
        return String.format("Product %d: %s, %s", id, name, getDisplayPrice());
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Product) {
            Product otherProduct = (Product) other;
            return (this.getName().equals(otherProduct.getName()))
                    && (this.getDescription().equals(otherProduct.getDescription()))
                    && (this.getPrice() == otherProduct.getPrice());
        }
        return false;
    }
}
