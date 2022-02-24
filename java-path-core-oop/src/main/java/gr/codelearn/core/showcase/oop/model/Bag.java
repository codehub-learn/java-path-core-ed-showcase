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
public class Bag {
    private ImmutableProduct product;
    private String customer;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ImmutableProduct getProduct() {
        return product;
    }

    public void setProduct(ImmutableProduct product) {
        this.product = product;
    }

    public void setProduct(String productName, BigDecimal price) {
        this.product = new ImmutableProduct(null, 
                productName,  price, 0, null);
    }
    
    @Override
    public String toString() {
        return "Bag{" + "product=" + product + ", customer=" + customer + '}';
    }

    
}
