package se.kth.iv1350.seminar3.model.DTO;

public class StoreAddressDTO{
    private String streetName;
    private int postNo;
    private String city;

    public StoreAddressDTO(String streetName, int postNo, String city){
        this.streetName = streetName;
        this.postNo = postNo;
        this.city = city;
    }
}