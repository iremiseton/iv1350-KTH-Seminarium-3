package se.kth.iv1350.seminar3.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar3.integration.data.InventorySystemDB;
import se.kth.iv1350.seminar3.model.Item;

/**
 * Stores all events during a sale.
 */
public class Sale {


    private List<Item> items = new ArrayList();
    private double discountAmount;
    private float totalPrice;
    private double totalVAT;
    private float change;
    
    private InventorySystemDB database;

    private Receipt receipt;
    
    /**
     * Creates a new instance of Sale.
     */
    public Sale(){
        database = new InventorySystemDB();
        database.connectToDatabase();
        items = database.updateList();

        this.receipt = new Receipt();
    }

    /**
     * Trys to get item from sale, 
     * if item does not exists function returns null.
     * 
     * @param barcode
     * @return
     */
    public Item getItem(int barcode) {
        for (Item item : this.items) {
            if (item.getBarcode() == barcode) {
                return item;
            }
        }
        return null;
    }

    
}
