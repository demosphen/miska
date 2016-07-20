package lv.javaguru.java2.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> cartProduct;

    public Cart(){
        this.cartProduct = new HashMap<Product, Integer>();
    }

    public void addProductToCart(Product product, int amount){
        for(Map.Entry<Product, Integer> entry: cartProduct.entrySet()){
            if(entry.getKey().equals(product)){
                cartProduct.put(product,entry.getValue() + amount);
            }else
                cartProduct.put(product, amount);
        }
    }

    public void deleteProductFromCart(Product product, int amount) throws MiskaException {
        for(Map.Entry<Product, Integer> entry : cartProduct.entrySet()){
            if(entry.getKey().equals(product)){
                if(entry.getValue() > amount){
                    cartProduct.put(product, entry.getValue() - amount);
                }else
                    cartProduct.remove(product);
            }else
                throw new MiskaException();
        }
    }

    public double calculatePrice(Map<Product, Integer> cart){
        double totalPrice = 0;
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
}
