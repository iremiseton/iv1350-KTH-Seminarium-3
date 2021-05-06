package se.kth.iv1350.seminar3.model.DTO;

/**
 *
 * @author SVT
 */
public class ReceiptDTO {
    private SaleDTO concludedSaleDTO;
    private String storeName;
    private String streetName;
    private int postalNumber;
    private String city;    
    private java.time.LocalDate saleDate = java.time.LocalDate.now();
    
    public ReceiptDTO(SaleDTO concludedSaleDTO, String storeName, String streetName, int postalNumber, String city, java.time.LocalDate saleDate){
        this.concludedSaleDTO = concludedSaleDTO;
        this.storeName = storeName;
        this.streetName = streetName;
        this.postalNumber = postalNumber;
        this.city = city;
    }
    
    /**
     * 
     * @return 
     */
    public SaleDTO getSaleDTO(){ return this.concludedSaleDTO; }
    /**
     * 
     * @return 
     */
    public String getStoreName(){ return this.storeName; }
    /**
     * 
     * @return 
     */
    public String getStreetName(){ return this.streetName; }
    /**
     * 
     * @return 
     */
    public int getPostalNumber(){ return this.postalNumber; }
    /**
     * 
     * @return 
     */
    public String getCity(){ return this.city; }
    /**
     * 
     * @return 
     */
    public java.time.LocalDate getSaleDate(){ return this.saleDate; }
}
