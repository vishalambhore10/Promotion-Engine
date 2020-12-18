package services.Promotion;

import Models.CartItem;
import Models.SKUItem;

import java.util.Set;

public class PromotionCD implements IPromotion{
    Set<SKUItem> skuList;
    int price;

    public PromotionCD(Set<SKUItem> skuList, int price) {
        this.skuList = skuList;
        this.price = price;
    }

    @Override
    public boolean isApplicable(CartItem... cartItem) {

        int matches = 0;
        for(CartItem item : cartItem)
        {
            if(skuList.contains(item.getSKUitem()))
            {
                matches++;
            }

        }
        return matches == skuList.size();
    }

    @Override
    public int calculatePrice(CartItem... cartItem) {

        if(!isApplicable(cartItem))
            return -1;
        int itemPrice = 0;
        for(CartItem item : cartItem)
        {
            if(!skuList.contains(item.getSKUitem()))
            {
                itemPrice += item.getSKUitem().getPrice() * item.getQuantity();
            }

        }
        return price + itemPrice;
    }
}
