package se.kth.iv1350.seminar3.model.DTO;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar3.model.DTO.ItemDTO;
/**
 *
 * @author SVT
 */
public class SaleDTO {
    private List<ItemDTO> shoppingCart = new ArrayList<>(); 
    private double discountAmount;
    private float totalPrice;
    private double totalVAT;
    private float change;

    public SaleDTO(List<ItemDTO> shoppingCart, double discountAmount, float totalPrice, double totalVAT, float change){
        this.shoppingCart = shoppingCart;
        this.discountAmount = discountAmount;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.change = change;
    }
    
    public List<ItemDTO> getShoppingCart(){ return this.shoppingCart; }

    /**
     * 
     * @return 
     */
    public double getDiscountAmount(){ return this.discountAmount; }

    /**
     * 
     * @return 
     */
    public float getTotalPrice(){ return this.totalPrice; }

    /**
     * 
     * @return 
     */
    public double getTotalVAT(){ return this.totalVAT; }

    /**
     * 
     * @return 
     */
    public float getChange(){ return this.change; }

}
