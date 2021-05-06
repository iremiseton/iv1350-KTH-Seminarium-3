package se.kth.iv1350.seminar3.model.DTO;

/**
 * 
 */
public class ItemDTO {
    private String name;
    private float price;
    private double VAT;
    private int barCode;
    

    public ItemDTO() {
        
    }
    /**
     * Creates an ItemDTO instanse that is read only and used to transfer Item data.
     * @param name - The name of the instance
     * @param price - The price of the instance
     * @param VAT - The VAT of the instance
     * @param barCode - The barcode of the instance
     */
    public ItemDTO(String name, float price, double VAT, int barCode){
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.barCode = barCode;
    }
    
    /**
     * This method reads ItemDTO's name.
     * @return the name.
     */
    public String getName(){ return this.name; }
    /**
     * This method reads ItemDTO's price.
     * @return the price.
     */
    public float getPrice(){ return this.price; }
    /**
     * This method reads ItemDTO's VAT.
     * @return the VAT.
     */
    public double getVAT(){ return this.VAT; }
    /**
     * This method reads ItemDTO's barcode.
     * @return The barcode.
     */
    public int getbarCode(){ return this.barCode; }
}
