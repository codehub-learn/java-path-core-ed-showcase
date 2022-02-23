
package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;


public class Product {
    private String serial;
    private String name;
    private BigDecimal price;

    public Product(String serial, String name, BigDecimal price) {
        this.serial = serial;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    private void whatever(){
        System.out.println("Whatever");
    }

    @Override
    public String toString() {
        return "Product{" + "serial=" + serial + ", name=" + name + ", price=" + price + '}';
    }
    
}
