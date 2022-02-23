package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;

public class Smartwatch extends Product{

    public Smartwatch(String serial, String name, BigDecimal price) {
        super(serial, name, price);
    }

    @Override
    public String toString() {
        return "Smartwatch{" +super.toString()+ '}';
    } 
}