/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;

/**
 *
 * @author iracl
 */
public class Coupon {
    private BigDecimal amount;
    


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Coupon(BigDecimal amount) {
        this.amount = amount;
    }

    public Coupon() {
    }
    
    @Override
    public String toString() {
        return "Coupon{" + "amount=" + amount + '}';
    }   
    
 }
