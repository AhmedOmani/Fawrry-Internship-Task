import model.* ;
import service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        Product cheese = new Product(
            "Cheese",100,2,
            new ShippingInfo(0.2),
            new ExpirationInfo(LocalDate.now().plusDays(5))
        );

        Product biscuit = new Product(
            "Biscuit", 150 , 1,
            new ShippingInfo(0.7),
            new ExpirationInfo(LocalDate.now().plusDays(2))
        );

        Product tv = new Product(
            "TV", 1000 , 3 ,
            new ShippingInfo(5.0),
            null
        );

        Product scratchCard = new Product(
            "Scratch Card" , 50 , 10 ,
            null,
            null
        );

        Product expiredMilk = new Product(
            "Milk", 20 , 5 ,
            new ShippingInfo(1.0),
            new ExpirationInfo(LocalDate.now().minusDays(1))
        );

        Customer customer = new Customer ("Omani" , 500);

        Cart cart = new Cart() ;

        cart.add(cheese , 2);
        cart.add(biscuit , 1) ;
        cart.add(scratchCard , 1);

        //Now lets handle all cases may happen.

        //1. Successful checkout.
        System.out.println("\n--- Successful checkout ---");
        CheckOutService.checkout(customer , cart);

        //2. Error: Empty cart.
        System.out.println("\n--- Empty cart ---");
        CheckOutService.checkout(customer , new Cart());

        //3. Unavailable items(expired).
        Cart expiredCart = new Cart() ;
        expiredCart.add(expiredMilk , 1);
        System.out.println("\n--- Product Expired ---");
        CheckOutService.checkout(customer, expiredCart);

        // 4. Product out of stock
        Cart outOfStockCart = new Cart();
        outOfStockCart.add(tv, 5); 
        System.out.println("\n--- Product Out of Stock ---");
        CheckOutService.checkout(customer, outOfStockCart);

        // 5. Insufficient balance.
        Customer poorCustomer = new Customer("Ahmed" , 100);
        Cart expensiveCart = new Cart();
        expensiveCart.add(tv , 1);
        System.out.println("\n--- Insufficient Balance ---");
        CheckOutService.checkout(poorCustomer, expensiveCart);

    }
}