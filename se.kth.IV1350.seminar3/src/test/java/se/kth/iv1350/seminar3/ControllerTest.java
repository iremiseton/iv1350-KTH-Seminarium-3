package se.kth.iv1350.seminar3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.controller.*;
import se.kth.iv1350.seminar3.integration.data.CustomerDB;
import se.kth.iv1350.seminar3.integration.data.InventorySystemDB;
import se.kth.iv1350.seminar3.integration.data.SaleLogDB;
import se.kth.iv1350.seminar3.integration.data.StoreAddressDB;
import se.kth.iv1350.seminar3.model.Sale;
import se.kth.iv1350.seminar3.model.DTO.ItemDTO;

public class ControllerTest {
    private Controller controller;
    private SaleLogDB saleLogDB;
    private StoreAddressDB storeAddressDB;
    private InventorySystemDB inventorySystemDB;
    private Sale currentSale;
    private CustomerDB customerDB;


    @BeforeEach
    void setup() {
        this.saleLogDB = new SaleLogDB();
        this.storeAddressDB = new StoreAddressDB("storeName", "streetName", 1259, "city");
        this.inventorySystemDB = new InventorySystemDB();
        this.controller = new Controller(this.saleLogDB, this.storeAddressDB); 
        this.customerDB = new CustomerDB();

        this.controller.startSale();
    }

    @Test
    void testScan() {
        this.controller.scan(1, 2);
    }

    @Test
    void testScanNotFindingItem() {
        try {
            this.controller.scan(23232, 4);
        } catch (java.lang.NullPointerException e) {
            assertEquals(e.getMessage(), "Cannot invoke \"se.kth.iv1350.seminar3.model.DTO.ItemDTO.getName()\" because \"temporalDTO\" is null");
        }
    }

    @Test
    void testSignalDiscount() {
        double disc = this.controller.signalDiscount(1);
        assertEquals(disc, 0.25);
    }

    @Test
    void testEndSale() {
        this.controller.endSale();
    }

    @Test
    void testRegisterPayment() {
        this.controller.registerPayment(250);
    }
    


}
