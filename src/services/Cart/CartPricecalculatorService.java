package services.Cart;

import Models.CartItem;
import services.Promotion.PromotionService;

import java.util.ArrayList;
import java.util.List;

public class CartPricecalculatorService {

    public int  calculateTotalPrice(Cart cart)
    {
        int totalPrice = 0;
        List<CartItem> ramainingCartItems = new ArrayList<>();
        List<CartItem> ItemCD = new ArrayList<>();
        for(CartItem cartItem : cart.getCartItems())
        {
            if(cartItem.getSKUitem().getSKU().equals("C") || cartItem.getSKUitem().getSKU().equals("D")){
                ItemCD.add(cartItem);
                continue;
            }
            int itemPrice =  PromotionService.calculatePromotion(cartItem);
            if(itemPrice != -1)
                totalPrice += itemPrice;
            else
                ramainingCartItems.add(cartItem);
        }
        if(ItemCD.size()==2){
            totalPrice +=PromotionService.calculatePromotion(ItemCD.toArray(new CartItem[ItemCD.size()]));
        }
        else if(ItemCD.size()==1){
            ramainingCartItems.add(ItemCD.get(0));
        }
        int remainingPrice = PromotionService.calculateRemainiingPrice(ramainingCartItems);
        System.out.print(totalPrice + remainingPrice);
        return totalPrice + remainingPrice;
    }
}
