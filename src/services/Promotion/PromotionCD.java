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
        int mn=Integer.MAX_VALUE;
        int mx=Integer.MIN_VALUE;
        CartItem id1=null,id2 = null;
        for(CartItem item : cartItem)
        {
            int temp=item.getQuantity();
            int temp1=item.getQuantity();
            if(temp<mn) {
                mn =temp;
                id1=item;
            }
            if(temp1>mx) {
                mx =temp1;
                id2=item;
            }
        }

        return price * mn+ id2.getSKUitem().getPrice()*(mx-mn);
    }
}
