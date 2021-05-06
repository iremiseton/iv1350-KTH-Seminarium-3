package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.integration.data.AccountingSystemDB;
/**
 *
 */
public class Payment {
    private float amountPaid;
    private AccountingSystemDB accSys;
    private float totalCost;
    private float change;
    
    /**
     * Processes a payment.
     * @param amount The amount paid by a customer.
     */
    public Payment(float amountPaid, AccountingSystemDB accSys){
        this.amountPaid = amountPaid;
        this.accSys = accSys;
    }
    
    /**
     * 
     * @return 
     */
    private void processPayment(float amountPaid){
        
    }
    
    /**
     * 
     * @return 
     */
    public float getChange(float totalCost, double discountAmount){
        float newTotalCost = totalCost;
        if (discountAmount > 0){
            newTotalCost = totalCost * (float)(1-discountAmount);
        }
        if(this.amountPaid >= newTotalCost){
            this.change = this.amountPaid - newTotalCost;
            accSys.updateAccountingDB(totalCost);
            return this.change; 
        }
        //ELSE THROWS "insufficient funds" argument.
         
        return -1;
    }
}
