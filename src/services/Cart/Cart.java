package services.Cart;

import Models.CartItem;

import java.util.HashSet;
import java.util.Set;

public class Cart {
    private Set<CartItem> cartItems = new HashSet<>();

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
