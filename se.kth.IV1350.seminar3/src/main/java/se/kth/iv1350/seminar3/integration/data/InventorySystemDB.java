package se.kth.iv1350.seminar3.integration.data;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;


import se.kth.iv1350.seminar3.model.Item;

public class InventorySystemDB{
    private List<Item> itemCatalog = new ArrayList();
    private String dbPath = "1 stol 250 0.125\n2 bank 230 0.125\n3 bajs 99 0.125\n4 koja 500 0.125";   

    public InventorySystemDB(){
        connectToDatabase();
    }

    public void connectToDatabase() {
            
            String[] spec = this.dbPath.split("\n");

            for (String line : spec) {
                
                String[] l = line.split(" ");

                Item newItem = new Item(
                    l[1], 
                    Float.parseFloat(l[2]), 
                    Double.parseDouble(l[3]), 
                    Integer.parseInt(l[0])
                );

                itemCatalog.add(newItem);
            }
    }

    public List<Item> updateList() {
        return this.itemCatalog;
    }


}