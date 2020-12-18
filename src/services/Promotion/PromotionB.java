package services.Promotion;

import Models.CartItem;

public class PromotionB implements IPromotion{
    Models.SKUItem SKUItem;
    int quantity;
    int price;

    @Override
    public boolean isApplicable(CartItem ...cartItem) {
        return cartItem[0].getSKUitem().getSKU().equals(this.SKUItem.getSKU())
                && cartItem[0].getQuantity() >= this.quantity;
    }

    @Override
    public int calculatePrice(CartItem... cartItem) {
        if(!isApplicable(cartItem))
            return -1;
        int discountedPrice = price + ((cartItem[0].getQuantity() - this.quantity) * cartItem[0].getSKUitem().getPrice());
        return discountedPrice;
    }
}
