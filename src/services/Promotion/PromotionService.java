package services.Promotion;

import Models.CartItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PromotionService {
    static Set<IPromotion> activePromotions = new HashSet<>();

    public static void addToActivePromotion(IPromotion... promotion){
        for(IPromotion p:promotion)
            activePromotions.add(p);
    }

    public static int calculatePromotion(CartItem... cartItem)
    {
        for(IPromotion promotion : activePromotions)
        {
            if(promotion.isApplicable(cartItem)) {
                return promotion.calculatePrice(cartItem);
            }
        }
        return -1;
    }
    public static  int calculateRemainiingPrice(List<CartItem> ramainingCartItems){
        int sum=0;
        for(CartItem cartItem:ramainingCartItems){
            sum+=cartItem.getSKUitem().getPrice()*cartItem.getQuantity();
        }
        return sum;
    }
}
