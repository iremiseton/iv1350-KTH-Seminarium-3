/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminar3.integration.data;

/**
 * This class keeps track of the store's bank balance.
 */
public class AccountingSystemDB {
    private float balance;
    
    /**
     * Creates one instans of the object.
     */
    public AccountingSystemDB(){
        
    }
    /**
     * Increases the stores balance.
     * @param totalCost is by how much the balance is to be increased.
     */
    public void updateAccountingDB(float totalCost){
        this.balance += totalCost;
    }
}
