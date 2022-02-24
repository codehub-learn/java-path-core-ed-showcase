/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.usecases;

import gr.codelearn.core.showcase.oop.model.Bag;
import gr.codelearn.core.showcase.oop.model.Coupon;
import gr.codelearn.core.showcase.oop.model.Customer;
import gr.codelearn.core.showcase.oop.model.ImmutableProduct;
import gr.codelearn.core.showcase.oop.model.Laptop;
import gr.codelearn.core.showcase.oop.model.Monitor;
import gr.codelearn.core.showcase.oop.model.Product;
import gr.codelearn.core.showcase.oop.model.SalesType;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author iracl
 */
public class SimpleUseCase {
    
    
     private static  final String CHOCOLATE_PRODUCT_NAME =  "chocolates"; 
    private static final String CHOCOLATE_PRODUCT_SERIAL =  "AB123"; 
    private static final  String VALUE_20 ="20"; 
    private static final String CUSTOMER_NAME =  "Leonidas"; 
    
    public void startUseCase(){
        Coupon coupon = new Coupon(new BigDecimal(VALUE_20));
        ImmutableProduct product = new ImmutableProduct(CHOCOLATE_PRODUCT_SERIAL, 
                CHOCOLATE_PRODUCT_NAME, BigDecimal.ONE, 0, coupon);
        Customer customer = new Customer();
        customer.setCustomerName(CUSTOMER_NAME);
        customer.setCustomerSurname("100Eye");
        customer.setDateOfBirth(new Date(100, 2, 15));
        Bag bag = new Bag();
        bag.setCustomer(customer);
        bag.setProduct(product);
        bag.setType(SalesType.RETAIL_SALES);
        System.out.println(bag);
        
        
        ////////////////////
        
        Product p1 = new Laptop(4, "SERIALN", "Asus", new BigDecimal ("800"));
        Product p2 = new Monitor("HI", "FF", "AOV", new BigDecimal ("100"));
     
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
        System.out.println(p2.calculateDiscount() ); 
    }
    
}
