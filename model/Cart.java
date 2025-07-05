package model ;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Cart {

    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product , int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive");
    
        items.put(product , items.getOrDefault(product , 0) + quantity);
    }

    public double getSubTotal() {
        double subtotal = 0.0 ;
        for (Map.Entry<Product , Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal;
    }

    public Map<Shippable , Integer> getShippableItems() {
        Map<Shippable, Integer> shippable = new HashMap<>();

        for (Map.Entry<Product , Integer> entry : items.entrySet()) {
            Product product = entry.getKey() ;
            if (product.isShippable()) {
                shippable.put(
                    new ShippableProduct(product.getName() , product.getShippingInfo().getWeight())
                , entry.getValue());
            }
        }

        return shippable;
    }

    //Expired || OutofStock items.
    public List<UnavailableItem> getUnavailableItems() {
        
        List<UnavailableItem> unavailable = new ArrayList<>() ;

        for (Map.Entry<Product , Integer> entry : items.entrySet()) {

            Product product = entry.getKey() ;
            int requestedQuantity = entry.getValue();

            if (product.isExpired()) {
                unavailable.add(new UnavailableItem(product , "Expired"));
            } 
            else if (product.getQuantity() > requestedQuantity) {
                unavailable.add(new UnavailableItem(product , "Out of Stock"));
            }
        }
        return unavailable;
    }



    
}