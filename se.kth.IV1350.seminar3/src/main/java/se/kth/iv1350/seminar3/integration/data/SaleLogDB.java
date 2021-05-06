package se.kth.iv1350.seminar3.integration.data;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar3.model.DTO.SaleDTO;

/**
 * Stores all previously made sales
 */
public class SaleLogDB {
    private List<SaleDTO> saleList = new ArrayList<SaleDTO>();
    
    /**
     * Creates an instance of SaleLogDB
     */
    public SaleLogDB(){
        
    }
    
    //public readSaleLog(){}
    
    
    public void storeSaleLog(SaleDTO completedSaleDTO){
        saleList.add(completedSaleDTO);
    }
}
