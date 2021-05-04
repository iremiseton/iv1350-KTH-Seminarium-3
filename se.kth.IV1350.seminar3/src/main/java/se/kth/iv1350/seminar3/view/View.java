package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.model.Item;
/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 * 
 */
public class View {
    private Controller controller;
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr the controller to use for all calls to other layers.
     */
    public View(Controller controller){
        this.controller = controller;
    }
    
    /**
     * Tells Controller to start a new sale.
     */
    public void startSale() {
        this.controller.startSale();
        System.out.println("Cashier starts new sale");
    }

    public Item scanItem(int barcode) {
        return this.controller.scan(barcode, 1);
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution(){
        this.controller.startSale();
        System.out.print("A new sale has been started.\n");
    }
}
