package test;

import Models.CartItem;
import Models.SKUItem;
import org.junit.jupiter.api.Test;
import services.Cart.Cart;
import services.Cart.CartPricecalculatorService;
import services.Promotion.*;

import java.util.Arrays;
import java.util.HashSet;

class CartPricecalculatorServiceTest {


    @Test
    void testcart(){
        SKUItem sku1 = new SKUItem("A",50);
        SKUItem sku2 = new SKUItem("B",30);
        SKUItem sku3 = new SKUItem("C",20);
        SKUItem sku4 = new SKUItem("D",15);

        IPromotion promotionA=new PromotionA(sku1,3,130);
        IPromotion promotionB=new PromotionB(sku2,2,45);
        IPromotion promotionCD=new PromotionCD(new HashSet<>(Arrays.asList(sku3,sku4)),30);

        PromotionService.addToActivePromotion((IPromotion) new HashSet<>(Arrays.asList(promotionA,promotionB,promotionCD)));

        Cart cart = new Cart();
        cart.addCartItem(new CartItem(1,sku1));
        cart.addCartItem(new CartItem(1,sku1));
        cart.addCartItem(new CartItem(1,sku1));

        CartPricecalculatorService cartService =new CartPricecalculatorService();
        cartService.calculateTotalPrice(cart);


    }
}