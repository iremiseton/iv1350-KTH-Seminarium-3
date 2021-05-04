package se.kth.iv1350.seminar3.startup;

import se.kth.iv1350.seminar3.integration.data.SaleLogDB;
import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.view.View;
/**
 * Starts the entire application. Contains the main method used to start the application.
 */
public class Main {
    /**
    * The main method used to start the entire application.
    * 
    * @param args The application does not take any command line parameters.
    */
    public static void main(String[] args){
        
        
        Controller contr = new Controller();
        View view = new View(contr);

        view.startSale();
        System.out.println(view.scanItem(2).getPrice());
    
    }
}
