package se.kth.iv1350.seminar3.model;

/**
 * Stores all events during a sale.
 */
public class Sale {
    private Receipt receipt;
    
    /**
     * Creates a new instance of Sale.
     */
    public Sale(){
        this.receipt = new Receipt();
    }
}
