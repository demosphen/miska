package lv.javaguru.java2.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Product {
    private long id;
    private String name;
    private String description;

    private  long categoryId;
    private Double price;
    private String imagePath;
    private Map<String,String> attributes = new HashMap<String, String>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Map<String,String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String,String> attributes) {
        this.attributes = attributes;
    }

    public String toString(){
        return "Product: " + id + " " + name;
    }
}
