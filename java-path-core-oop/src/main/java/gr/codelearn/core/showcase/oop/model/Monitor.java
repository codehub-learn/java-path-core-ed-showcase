package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;


public class Monitor extends Product{
    private String resolution;

    public Monitor() {
    }
    
    public Monitor(String resolution, String serial, String name, BigDecimal price) {
        super(serial, name, price);
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Monitor{"+ super.toString() + ", resolution=" + resolution + '}';
    }

    @Override
    public BigDecimal calculateDiscount() {
        BigDecimal discount = new BigDecimal("0.15");
        return  getPrice().multiply(discount);
     }
 }
