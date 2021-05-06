package se.kth.iv1350.seminar3.integration.data;

/**
 *
 * @author SVT
 */
public class ItemTemplate {
    private String name;
    private float price;
    private double VAT;
    private int barCode;
    
    public ItemTemplate(String name, float price, double VAT, int barCode){
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.barCode = barCode;
    }

    public String getName(){ return this.name; }
    public float getPrice(){ return this.price; }
    public double getVAT(){ return this.VAT; }
    public int getBarCode(){ return this.barCode; }

}
