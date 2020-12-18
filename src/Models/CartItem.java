package Models;

public class CartItem {

    int quantity;
    SKUItem itemSKU;

    public CartItem(int quantity, SKUItem itemSKU) {
        this.quantity = quantity;
        this.itemSKU = itemSKU;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SKUItem getItemSKU() {
        return itemSKU;
    }

    public void setItemSKU(SKUItem itemSKU) {
        this.itemSKU = itemSKU;
    }
}
