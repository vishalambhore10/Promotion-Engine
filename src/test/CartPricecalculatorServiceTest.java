package test;

import Models.CartItem;
import Models.SKUItem;
import org.junit.jupiter.api.Test;
import services.Cart.Cart;
import services.Cart.CartPricecalculatorService;
import services.Promotion.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartPricecalculatorServiceTest {

    SKUItem sku1 = new SKUItem("A",50);
    SKUItem sku2 = new SKUItem("B",30);
    SKUItem sku3 = new SKUItem("C",20);
    SKUItem sku4 = new SKUItem("D",15);

    IPromotion promotionA=new PromotionA(sku1,3,130);
    IPromotion promotionB=new PromotionB(sku2,2,45);
    IPromotion promotionCD=new PromotionCD(new HashSet<>(Arrays.asList(sku3,sku4)),30);

    CartPricecalculatorService cartService =new CartPricecalculatorService();

    @Test
    void testcart(){
        PromotionService.addToActivePromotion(promotionA);
        PromotionService.addToActivePromotion(promotionB);
        PromotionService.addToActivePromotion(promotionCD);

        Cart cart = new Cart();
        cart.addCartItem(new CartItem(1,sku1));
        cart.addCartItem(new CartItem(1,sku2));
        cart.addCartItem(new CartItem(1,sku3));


        assertEquals(100,cartService.calculateTotalPrice(cart));
    }

    @Test
    void testcase2(){
        PromotionService.addToActivePromotion(promotionA);
        PromotionService.addToActivePromotion(promotionB);
        PromotionService.addToActivePromotion(promotionCD);

        Cart cart = new Cart();
        cart.addCartItem(new CartItem(5,sku1));
        cart.addCartItem(new CartItem(5,sku2));
        cart.addCartItem(new CartItem(1,sku3));

        assertEquals(370,cartService.calculateTotalPrice(cart));
    }
    @Test
    void testcase3(){
        PromotionService.addToActivePromotion(promotionA);
        PromotionService.addToActivePromotion(promotionB);
        PromotionService.addToActivePromotion(promotionCD);

        Cart cart = new Cart();
        cart.addCartItem(new CartItem(3,sku1));
        cart.addCartItem(new CartItem(5,sku2));
        cart.addCartItem(new CartItem(1,sku3));
        cart.addCartItem(new CartItem(1,sku4));

        assertEquals(280,cartService.calculateTotalPrice(cart));
    }

    @Test
    void testcase4(){
        PromotionService.addToActivePromotion(promotionA);
        PromotionService.addToActivePromotion(promotionB);
        PromotionService.addToActivePromotion(promotionCD);

        Cart cart = new Cart();
        cart.addCartItem(new CartItem(3,sku1));
        cart.addCartItem(new CartItem(5,sku2));
        cart.addCartItem(new CartItem(2,sku3));
        cart.addCartItem(new CartItem(1,sku4));

        assertEquals(300,cartService.calculateTotalPrice(cart));
    }
}