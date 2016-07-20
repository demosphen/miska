package lv.javaguru.java2.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Product> productList = new ArrayList<Product>();

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    @Override
    public String toString() {
        return "Category{" + "name='" + name + '\'' + '}';
    }
}
