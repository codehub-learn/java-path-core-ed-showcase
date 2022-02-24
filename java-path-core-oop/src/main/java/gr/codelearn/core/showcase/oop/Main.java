package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Bag;
import gr.codelearn.core.showcase.oop.model.Coupon;
import gr.codelearn.core.showcase.oop.model.ImmutableProduct;
import gr.codelearn.core.showcase.oop.model.Laptop;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
 
        String name = "chocolates";
        String serial = "AB123";
        
        Coupon coupon = new Coupon(new BigDecimal("20"));
        ImmutableProduct product = new ImmutableProduct(serial, name, BigDecimal.ONE, 0,  coupon);
     
        
        Bag bag = new Bag();
        bag.setCustomer("Dimiotris");
        bag.setProduct(product);
        bag.setProduct("chichlets", new BigDecimal("1.20"));
         
        System.out.println(bag);
       
    }
}
