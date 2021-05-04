package se.kth.iv1350.seminar3.integration.data;

import se.kth.iv1350.seminar3.model.DTO.StoreAddressDTO;

/**
 * 
 */
public class StoreAddressDB{
    
    private String streetName = "Isafjordsgatan 22";
    private int postNo = 16440;
    private String city = "Stockholm";
    
    public StoreAddressDB(){}

    /**
     * Return adress information via a DTO.
     * @param 
     */
    public StoreAddressDTO getStoreAddress(){
        StoreAddressDTO storeAdrDTO = new StoreAddressDTO(streetName, postNo, city);
        return storeAdrDTO;
    }

} 