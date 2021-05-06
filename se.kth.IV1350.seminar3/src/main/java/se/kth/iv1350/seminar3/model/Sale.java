package se.kth.iv1350.seminar3.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar3.model.Receipt;

import se.kth.iv1350.seminar3.integration.data.StoreAddressDB;
import se.kth.iv1350.seminar3.integration.data.CustomerDB;
import se.kth.iv1350.seminar3.integration.data.InventorySystemDB;

import se.kth.iv1350.seminar3.model.DTO.ItemDTO;
import se.kth.iv1350.seminar3.model.DTO.SaleDTO;

/**
 * Stores all events during a sale.
 */
public class Sale {
    private Receipt receipt;
    private Payment payment;
    private List<ItemDTO> shoppingCart = new ArrayList<>(); 
    private double discountAmount;
    private float totalPrice;
    private double totalVAT;
    private float change;

    
    /**
     * Creates a new instance of Sale.
     */
    public Sale(StoreAddressDB storeAdr){
        Receipt receipt = new Receipt(storeAdr);
        this.receipt = receipt;
    }
    
    //public Receipt getReceiptInstanse(){ return this.receipt; }
    
    /**
     * 
     * @param barCode
     * @param quantity
     * @return 
     */
    public void addItemToSale(ItemDTO itemDTO, int quantity){
        for(int i = 0; i < quantity; i++){
            shoppingCart.add(itemDTO);
        }
    }
    
    
    public double getDiscountAmount(int customerID, CustomerDB custDB){
        this.discountAmount = custDB.getDiscountRate(customerID);
        return this.discountAmount;
    }
    
    
    public SaleDTO displaySale(){
        for(int i = 0; i < shoppingCart.size(); i++){
            this.totalPrice += shoppingCart.get(i).getPrice();
            this.totalVAT += shoppingCart.get(i).getVAT();
        }
        SaleDTO concludedSale = new SaleDTO(this.shoppingCart, this.discountAmount, this.totalPrice, this.totalVAT, this.change);
        return concludedSale;
    }
    
    public SaleDTO getSaleInfo(Payment payment, InventorySystemDB invSys){
        this.change = payment.getChange(this.totalPrice, this.discountAmount);
        if(this.change == -1){
            //ERROR ocurred in Payment during getChange(...);
        }
        SaleDTO completeSaleDTO = new SaleDTO(this.shoppingCart, this.discountAmount, this.totalPrice, this.totalVAT, this.change);
        
        invSys.updateInventory(completeSaleDTO);
        
        return completeSaleDTO;
    }
    
}
