package service ;

import model.Cart ;
import model.UnavailableItem;
import java.util.List;
public class CartValidationService {

    public static boolean isEmpty(Cart cart) {
        return cart.isEmpty();
    }

    public static List<UnavailableItem> getUnavailableItems(Cart cart) {
        return cart.getUnavailableItems();
    }
    
}