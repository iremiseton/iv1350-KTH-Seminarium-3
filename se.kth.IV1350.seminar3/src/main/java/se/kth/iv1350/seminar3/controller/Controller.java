package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.model.DTO.ItemDTO;
import se.kth.iv1350.seminar3.model.DTO.SaleDTO;
import se.kth.iv1350.seminar3.model.DTO.ReceiptDTO;

import se.kth.iv1350.seminar3.model.Item;
import se.kth.iv1350.seminar3.model.Sale;
import se.kth.iv1350.seminar3.model.Receipt;
import se.kth.iv1350.seminar3.model.Payment;

import se.kth.iv1350.seminar3.integration.data.AccountingSystemDB;
import se.kth.iv1350.seminar3.integration.data.CustomerDB;
import se.kth.iv1350.seminar3.integration.data.InventorySystemDB;
import se.kth.iv1350.seminar3.integration.data.SaleLogDB;
import se.kth.iv1350.seminar3.integration.data.StoreAddressDB;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 * 
 */
public class Controller {    
    private InventorySystemDB invSys;
    private CustomerDB custDB;
    private AccountingSystemDB accSys;
    private SaleLogDB saleLog;
    private StoreAddressDB storeAddress;
    
    private Receipt receipt;    
    private Sale currentSale;
    private Payment payment;
    
    /**
     * 
     */
    public Controller(SaleLogDB saleLog, StoreAddressDB storeAddress){
        InventorySystemDB invSys = new InventorySystemDB();
        this.invSys = invSys;
        
        CustomerDB custDB = new CustomerDB();
        this.custDB = custDB;
        
        AccountingSystemDB accSys = new AccountingSystemDB();
        this.accSys = accSys;
        
        this. saleLog = saleLog;
        
        this.storeAddress = storeAddress;

        this.receipt = new Receipt(storeAddress);
    }
    
    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale(){
        //Skapar sale o sparar dess instans.
        Sale currentSale = new Sale(this.storeAddress);
        this.currentSale = currentSale;
    }
    
    /**
     * 1) Skapar en Item, går till Inventory system o fyller på detta item.
     * 2) Förbereder Item for transport till sale genom skapandet av ItemDTO.
     * @param barCode
     * @param quantity
     * @return 
     */
    public ItemDTO scan(int barCode, int quantity){
        Item item = new Item(barCode, this.invSys);
        
        ItemDTO itemDTO = new ItemDTO(item.getName(), item.getPrice(), item.getVAT(), item.getbarCode());
        this.currentSale.addItemToSale(itemDTO, quantity);
        
        return itemDTO;
    }
    
    
    public double signalDiscount(int customerID){
        double discountRate = currentSale.getDiscountAmount(customerID, custDB);
        return discountRate;
    }
    
    
    public SaleDTO endSale(){
        SaleDTO concludedSale = currentSale.displaySale();
        return concludedSale;
    }
    
    
    public ReceiptDTO registerPayment(float amount){
        Payment payment = new Payment(amount, accSys);
        this.payment = payment;
        
        ReceiptDTO receiptDTO = receipt.printReceipt(this.payment, this.currentSale, this.saleLog, this.invSys);
        return receiptDTO;
    }
    
}
