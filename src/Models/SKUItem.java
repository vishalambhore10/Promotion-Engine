package Models;

public class SKUItem {
    String SKU;
    int price;

    public SKUItem(String SKU,int price){
        this.SKU=SKU;
        this.price=price;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
