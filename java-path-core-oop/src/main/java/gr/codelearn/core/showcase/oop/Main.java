package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Bag;
import gr.codelearn.core.showcase.oop.model.Coupon;
import gr.codelearn.core.showcase.oop.model.Customer;
import gr.codelearn.core.showcase.oop.model.ImmutableProduct;
import gr.codelearn.core.showcase.oop.model.Laptop;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
 
        String name = "chocolates";
        String serial = "AB123";
        
        Coupon coupon = new Coupon(new BigDecimal("20"));
        ImmutableProduct product = new ImmutableProduct(serial, name, BigDecimal.ONE, 0,  coupon);
     Customer customer = new Customer();
     customer.setCustomerName("Leonidas");
     customer.setCustomerSurname("100Eye");
     customer.setDateOfBirth(new Date(100,2,15));
        
        Bag bag = new Bag();
        bag.setCustomer(customer);
        bag.setProduct(product);
        
        System.out.println(bag);
       
      
 
        
    }
}
