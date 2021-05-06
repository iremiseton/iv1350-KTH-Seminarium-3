package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.integration.data.StoreAddressDB;

import se.kth.iv1350.seminar3.model.DTO.StoreAddressDTO;
import se.kth.iv1350.seminar3.model.DTO.SaleDTO;
import se.kth.iv1350.seminar3.model.DTO.ReceiptDTO;

import se.kth.iv1350.seminar3.model.Sale;

import se.kth.iv1350.seminar3.integration.data.InventorySystemDB;
import se.kth.iv1350.seminar3.integration.data.SaleLogDB;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt{
    private SaleDTO concludedSaleDTO;
    private String storeName;
    private String streetName;
    private int postalNumber;
    private String city;    
    private java.time.LocalDate saleDate = java.time.LocalDate.now();
    
    private float change;
    
    public Receipt(StoreAddressDB storeAdr){
        StoreAddressDTO temporalDTO = storeAdr.getStoreAddress();
        this.storeName = temporalDTO.getStoreName();
        this.streetName = temporalDTO.getStreetName();
        this.postalNumber = temporalDTO.getPostalNumber();
        this.city = temporalDTO.getCity();
    }
   
    
    public ReceiptDTO printReceipt(Payment payment, Sale currentSale, SaleLogDB saleLog, InventorySystemDB invSys){
        SaleDTO concludedSaleDTO = currentSale.getSaleInfo(payment, invSys);
        this.concludedSaleDTO = concludedSaleDTO;
        
        ReceiptDTO receitDTO = new ReceiptDTO(this.concludedSaleDTO, this.storeName, this.streetName, this.postalNumber, this.city, this.saleDate);
        
        saleLog.storeSaleLog(concludedSaleDTO);
    
        return receitDTO;
        //concludedSaleDTO.getChange()
    }
    
    public String getStoreName(){ return this.storeName; }
    public String getStreetName(){ return this.streetName; }
    public int getPostalNumber(){ return this.postalNumber; }
    public String getCity(){ return this.city; }
    public java.time.LocalDate getSaleDate(){ return this.saleDate; }
    
    
}
