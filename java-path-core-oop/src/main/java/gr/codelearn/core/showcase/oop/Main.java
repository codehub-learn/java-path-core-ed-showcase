package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Coupon;
import gr.codelearn.core.showcase.oop.model.ImmutableProduct;
import gr.codelearn.core.showcase.oop.model.Laptop;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
//        laptop.setSerial("LP50X22");
//        laptop.setName("ThinkBook");
//        laptop.setPrice(new BigDecimal("700.50"));
//     
//        System.out.println("Laptop serial: "+ laptop.getSerial());
//        System.out.println("Laptop name: "+ laptop.getName());
//        System.out.println("Laptop price: "+ laptop.getPrice());
//        System.out.println(laptop);
//        
//        Laptop laptop2 = new Laptop(4,"LP30x21","Inspitation",new BigDecimal("200"));
//        System.out.println(laptop2);
        String name = "chocolates";
        String serial = "AB123";
        
        Coupon coupon = new Coupon(new BigDecimal("20"));
        ImmutableProduct product = new ImmutableProduct(serial, name, BigDecimal.ONE, 0,  coupon);
     
        System.out.println(product);
        
        coupon =  new Coupon(new BigDecimal("120"));
       // coupon.setAmount(new BigDecimal("30"));
        
        System.out.println(product);
       
    }
}
