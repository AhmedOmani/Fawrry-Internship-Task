package service ;

import model.Shippable;
import java.util.Map;

public class ShippingService {

    public static double processShipment(Map<Shippable , Integer> shippableItems) {
        
        if (shippableItems == null || shippableItems.isEmpty()) return 0.0 ;

        double totalWeight = 0.0 ;
        System.out.println("*** Shipment notice ***");

        for (Map.Entry<Shippable , Integer> entry : shippableItems.entrySet()) {

            Shippable item = entry.getKey();
            int quantity = entry.getValue();
            double itemWeight = item.getWeight() * quantity;
            totalWeight += itemWeight;

            String name = item.getName() ;
            String paddedName = String.format("%-15s" , name);
            System.out.printf("%dx %s%7.0fg\n", quantity, paddedName, item.getWeight() * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
        return totalWeight;

    }

    //I assumed that the shipping cost is 30$ per kg as mentioned in the problem statement.
    public static double calculateShippingCost(double totalWeight) {
        return totalWeight * 30 ;
    }
}