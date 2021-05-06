package se.kth.iv1350.seminar3.integration.data;

import se.kth.iv1350.seminar3.model.DTO.StoreAddressDTO;

/**
 *
 * @author SVT
 */
public class StoreAddressDB {
    private String storeName;
    private String streetName;
    private int postalNumber;
    private String city;
    
    /**
     * 
     * @param streetName
     * @param postalNumber
     * @param city 
     */
    public StoreAddressDB(String storeName, String streetName, int postalNumber, String city){
        this.storeName = storeName;
        this.streetName = streetName;
        this.postalNumber = postalNumber;
        this.city = city;
    }
    
    public StoreAddressDTO getStoreAddress(){
        StoreAddressDTO storeAddressDTO = new StoreAddressDTO(this.storeName, this.streetName, this.postalNumber, this.city);
        return storeAddressDTO;
    }
    
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
