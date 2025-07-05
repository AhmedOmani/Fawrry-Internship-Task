package service ;

import model.*;
import java.util.List;
import java.util.Map;

public class CheckOutService {

    public static void checkout(Customer customer , Cart cart) {

        //Validate that customer put items in the cart 
        if (CartValidationService.isEmpty(cart)) {
            System.out.println("Cart is empty");
            return ;
        }

        //Collect the unavailable items that user chooeses .
        List<UnavailableItem> unavailableItems = CartValidationService.getUnavailableItems(cart);
        if (!unavailableItems.isEmpty()) {
            System.out.println("Some products are unavailable.");
            for (UnavailableItem item : unavailableItems) {
                System.out.printf("- %s (%s)\n", item.getProduct().getName(), item.getReason());
            }
            return ;
        }

        //Calc subtotal of products.
        double subtotal = cart.getSubTotal();

        // Calculate shipping cost if there are any shippable items.
        Map<Shippable, Integer> shippableItems = cart.getShippableItems();
        double shipping = 0.0 ;
        if (!shippableItems.isEmpty()) {
            double totalWeight = ShippingService.processShipment(shippableItems) ;
            shipping = ShippingService.calculateShippingCost(totalWeight);
        }
        
        //Calculate total amount.
        double totalAmount = subtotal + shipping ;

        //Check customer balance.
        if (customer.getBalance() < totalAmount) {
            System.out.println("Customer's balance is insufficient.");
            return;
        }

        //Deduct the balance.
        customer.deductBalance(totalAmount);

        //Print receopt.
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double totalPrice = product.getPrice() * quantity;
            System.out.printf("%dx %s\t%.0f\n", quantity, product.getName(), totalPrice);
        }

        System.out.println("---------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", totalAmount);
        
    } 
}