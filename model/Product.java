package model;

//Compostion over Inheritance.
public class Product {
    private String name;
    private double price;
    private int quantity ;
    private ShippingInfo shippingInfo ;
    private ExpirationInfo expirationInfo ;

    public Product(String name , double price , int quantity , ShippingInfo shippingInfo , ExpirationInfo expirationInfo){
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");
       
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippingInfo = shippingInfo;
        this.expirationInfo = expirationInfo;
    } 

    public boolean isShippable() {
        return this.shippingInfo != null ;
    }

    public boolean isExpirable() {
        return this.expirationInfo != null ;
    }

    public boolean isExpired () {
        return isExpirable() && this.expirationInfo.isExpired();
    }  

    public boolean isOutOfStock() {
        return this.quantity <= 0;
    }

    public boolean isAvailable(int requestedQuantity) {
        return !isExpired() && this.quantity >= requestedQuantity;
    }

    public String getName() { 
        return this.name; 
    }
    
    public double getPrice() {
        return this.price; 
    }
    
    public int getQuantity() { 
        return this.quantity; 
    }

    public ShippingInfo getShippingInfo() {
        return this.shippingInfo;
    }
    
    public void reduceQuantity(int amount) {
        if (amount > 0 && amount <= this.quantity) {
            this.quantity -= amount ;
        }
    }

}