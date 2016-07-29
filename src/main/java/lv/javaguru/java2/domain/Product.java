package lv.javaguru.java2.domain;

public class Product {
    private long id;
    private String name;
    private String description;
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
