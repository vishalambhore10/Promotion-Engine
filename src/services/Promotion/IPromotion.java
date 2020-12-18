package services.Promotion;

import Models.CartItem;

public interface IPromotion {
    boolean isApplicable(CartItem... cartItem);
    int calculatePrice(CartItem... cartItem);
}
