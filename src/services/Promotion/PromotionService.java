package services.Promotion;

import Models.CartItem;

import java.util.HashSet;
import java.util.Set;

public class PromotionService {
    static Set<IPromotion> activePromotions = new HashSet<>();

    public static void addToActivePromotion(IPromotion promotion){
        activePromotions.add(promotion);
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
}
