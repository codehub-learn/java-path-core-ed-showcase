/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.stream;

import java.math.BigDecimal;

/**
 *
 * @author mcjohn1
 */
public class Invoice {
    private int quantity;
    private BigDecimal price;
    private String code;

    public Invoice(int quantity, BigDecimal price, String code) {
        this.quantity = quantity;
        this.price = price;
        this.code = code;
    }
    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
}
