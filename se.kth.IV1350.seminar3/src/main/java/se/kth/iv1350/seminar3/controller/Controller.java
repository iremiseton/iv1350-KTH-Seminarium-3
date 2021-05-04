package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.model.Sale;
/**
 * This is the application's only controller. All calls to the model pass through this class.
 * 
 */
public class Controller {
    private Sale currentSale;
    
    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale(){
        currentSale = new Sale();
    }
}
