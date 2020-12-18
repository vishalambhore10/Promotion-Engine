package Models;

public class CartItem {

    int quantity;
    SKUItem SKUitem;

    public CartItem(int quantity, SKUItem itemSKU) {
        this.quantity = quantity;
        this.SKUitem = itemSKU;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SKUItem getSKUitem() {
        return SKUitem;
    }

    public void setItemSKU(SKUItem itemSKU) {
        this.SKUitem = itemSKU;
    }
}
