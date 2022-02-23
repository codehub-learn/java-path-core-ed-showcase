package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;


public class Monitor extends Product{
    private String resolution;

    public Monitor(String resolution, String serial, String name, BigDecimal price) {
        super(serial, name, price);
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Monitor{"+ super.toString() + ", resolution=" + resolution + '}';
    }
 
}
