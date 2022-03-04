
package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;


public abstract class Product {
    protected String serial;
    protected String name;
    protected BigDecimal price;
    protected int inventoryQuantity;
    
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
    
   

    @Override
    public String toString() {
        return "Product{" + "serial=" + serial + ", name=" + name + ", price=" + price + '}';
    }
    
    
    public abstract BigDecimal calculateDiscount();
}
