package se.kth.iv1350.seminar3.model.DTO;

/**
 *
 */
public class StoreAddressDTO {
    private String storeName;
    private String streetName;
    private int postalNumber;
    private String city;
    
    /**
     * 
     * @param storeName
     * @param streetName
     * @param postalNumber
     * @param city 
     */
    public StoreAddressDTO(String storeName, String streetName, int postalNumber, String city){
        this.storeName = storeName;
        this.streetName = streetName;
        this. postalNumber = postalNumber;
        this.city = city;
    }
    
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
}
