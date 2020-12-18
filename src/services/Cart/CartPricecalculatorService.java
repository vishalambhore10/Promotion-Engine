package services.Cart;

import Models.CartItem;
import services.Promotion.PromotionService;

import java.util.ArrayList;
import java.util.List;

public class CartPricecalculatorService {

    public int  calculateTotalPrice(CartServices cart)
    {
        int totalPrice = 0;
        List<CartItem> ramainingCartItems = new ArrayList<>();

        for(CartItem cartItem : cart.getCartItems())
        {
            int itemPrice =  PromotionService.calculatePromotion(cartItem);
            if(itemPrice != -1)
                totalPrice += itemPrice;
            else
                ramainingCartItems.add(cartItem);
        }
        int remainingPrice = PromotionService.calculatePromotion(ramainingCartItems.toArray(new CartItem[ramainingCartItems.size()]));
        System.out.print(totalPrice + remainingPrice);
        return totalPrice + remainingPrice;
    }
}
