package Models;

public class Item {
    // Attributes
    private int ordid;
    private int itemid;
    private int prodid;
    private double actualPrice;
    private int qty;
    private double itemtot;

    // Methods: Builder
    public Item(int ordid, int itemid, int prodid, double actualPrice, int qty, double itemtot) {
        this.ordid = ordid;
        this.itemid = itemid;
        this.prodid = prodid;
        this.actualPrice = actualPrice;
        this.qty = qty;
        this.itemtot = itemtot;
    }

    // Methods: Getter
    public int getOrdid() {
        return ordid;
    }

    public int getItemid() {
        return itemid;
    }

    public int getProdid() {
        return prodid;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public int getQty() {
        return qty;
    }

    public double getItemtot() {
        return itemtot;
    }

    // Methods: Setter
    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setItemtot(double itemtot) {
        this.itemtot = itemtot;
    }

    // Methods: toString()
    @Override
    public String toString() {
        return "Item{" +
                "ordid=" + ordid +
                ", itemid=" + itemid +
                ", prodid=" + prodid +
                ", actualPrice=" + actualPrice +
                ", qty=" + qty +
                ", itemtot=" + itemtot +
                '}';
    }
}
