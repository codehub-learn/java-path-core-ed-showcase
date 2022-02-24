package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;

public class Laptop extends Product{
    private int cpuCoreCount;

    public int getCpuCoreCount() {
        return cpuCoreCount;
    }

    public void setCpuCoreCount(int cpuCoreCount) {
        this.cpuCoreCount = cpuCoreCount;
    }

   
    public Laptop(){
        
    }

    public Laptop(int cpuCoreCount, String serial, String name, BigDecimal price) {
        super(serial, name, price);
        this.cpuCoreCount = cpuCoreCount;
    }

    @Override
    public String toString() {
        return "Laptop{"+super.toString() + ", cpuCoreCount=" + cpuCoreCount + '}';
    }

    @Override
    public BigDecimal calculateDiscount() {
        BigDecimal discount = new BigDecimal("0.1");
        return  price.multiply(discount);
    }

}
