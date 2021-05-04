package se.kth.iv1350.seminar3.model;

public class Item {
    
    private String name;
    private float price;
    private double VAT;
    private int barCode;
    

    /**
     *  Constructor for Item.
     * 
     * @param name
     * @param price
     * @param VAT
     * @param barCode
     */

    public Item(String name, 
                float price, 
                double VAT, 
                int barCode) {

                    this.name = name;
                    this.price = price;
                    this.VAT = VAT;
                    this.barCode = barCode;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public double getVAT() {
        return this.VAT;
    }

    public int getBarcode() {
        return this.barCode;
    }

    public String toString() {
        return this.name;
    }
}
