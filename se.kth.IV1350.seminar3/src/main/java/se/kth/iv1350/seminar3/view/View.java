package se.kth.iv1350.seminar3.view;

import java.util.Scanner;

import se.kth.iv1350.seminar3.controller.Controller;

import se.kth.iv1350.seminar3.model.DTO.ItemDTO;
import se.kth.iv1350.seminar3.model.DTO.SaleDTO;
import se.kth.iv1350.seminar3.model.DTO.ReceiptDTO;
/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 * 
 */
public class View {
    private static final int CUSTOMERID = 1;
    private static final int BARCODE = 1;
    private static final int QUANTITY = 1;
    private static final int AMOUNT = 500;

    private Controller contr;
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr the controller to use for all calls to other layers.
     */
    public View (Controller contr){
        this.contr = contr;
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.print("A new sale has been started.\n");
        
        ItemDTO itemDTO = contr.scan(BARCODE,QUANTITY);
        System.out.println(itemDTO.getName() + "\t" + itemDTO.getPrice() + "\t" + itemDTO.getVAT());
        
        double discountRate = contr.signalDiscount(CUSTOMERID);
        System.out.println("Eligable discount: " + (discountRate*100.00) + "%");
        
        
        SaleDTO concludedSale = contr.endSale();
        printConcludedSale(concludedSale);
    
        
        float amount = AMOUNT;
        ReceiptDTO receiptDTO = contr.registerPayment(amount);
        printReceipt(receiptDTO, concludedSale);
    }
    
    private void printConcludedSale(SaleDTO concludedSale){
       printItems(concludedSale);
    }
    private void printItems(SaleDTO concludedSale){
        for(int i = 0; i < concludedSale.getShoppingCart().size(); i++){
            System.out.println(concludedSale.getShoppingCart().get(i).getName() + "\t" +
                                concludedSale.getShoppingCart().get(i).getPrice() + "\t" +
                                concludedSale.getShoppingCart().get(i).getVAT() + "\t");
        }
    }

    /**
     * Prints Receipt
     * @param receiptDTO
     * @param concludedSale 
     */
    private void printReceipt(ReceiptDTO receiptDTO, SaleDTO concludedSale){
        printIntro();
        printItems(concludedSale);
        printOutro(receiptDTO);
    }
    private void printIntro(){
        System.out.println("Welcome Back!");
    }
    private void printOutro(ReceiptDTO receiptDTO){
        System.out.println(receiptDTO.getSaleDate() + "\n" +
                            receiptDTO.getStoreName() + "\n" +
                            receiptDTO.getStreetName() + ", " + receiptDTO.getPostalNumber() + ", " + receiptDTO.getCity());
        
    }
}
