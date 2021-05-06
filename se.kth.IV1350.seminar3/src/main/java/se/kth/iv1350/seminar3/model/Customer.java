package se.kth.iv1350.seminar3.model;

/**
 *
 */
public class Customer {
    private String name;
    private int age;
    private int customerID;
    private double discountRate;
    
    public Customer(String name, int age, int customerID, double discountRate){
        this.name = name;
        this.age = age;
        this.customerID = customerID;
        this.discountRate = discountRate;
    }
    /**
     * 
     * @return 
     */
    public String getName(){ return this.name; }
    /**
     * 
     * @return 
     */
    public int getage(){ return this.age; }
    /**
     * 
     * @return 
     */
    public int getCustomerID(){ return this.customerID; }
    /**
     * 
     * @return 
     */
    public double getDiscountRate(){ return this.discountRate; }
}