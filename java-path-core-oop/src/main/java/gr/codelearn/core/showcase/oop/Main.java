package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Bag;
import gr.codelearn.core.showcase.oop.model.Coupon;
import gr.codelearn.core.showcase.oop.model.Customer;
import gr.codelearn.core.showcase.oop.model.ImmutableProduct;
import gr.codelearn.core.showcase.oop.model.Laptop;
import gr.codelearn.core.showcase.oop.model.Monitor;
import gr.codelearn.core.showcase.oop.model.Product;
import gr.codelearn.core.showcase.oop.model.SalesType;
import gr.codelearn.core.showcase.oop.repository.CustomerRepository;
import gr.codelearn.core.showcase.oop.repository.CustomerRepositoryArrayListImpl;
import gr.codelearn.core.showcase.oop.service.RetailBusiness;
import gr.codelearn.core.showcase.oop.service.RetailBusinessImpl;
import gr.codelearn.core.showcase.usecases.SimpleUseCase;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
This is the main class
*/

public class Main {
    
    
   
/**
 * 
 * @param args 
 */
    public static void main(String[] args) {
        
        CustomerRepository customerRepository = new CustomerRepositoryArrayListImpl();
        
        Customer customer = new Customer(0, "Sofia", "Sofiou", "Ath", new Date(100, 2,10), true, 100);
        customerRepository.createCustomer(customer);
        customerRepository.createCustomer(new Customer(5, "Dim", "Dim","Ath", new Date(100, 2,10), true, 300 ));
        
        
        customerRepository.updateCustomer(2, "Lamia");
        
        List<Customer> customers= customerRepository.readCustomer();
        for (Customer customer2 : customers){
            System.out.println(customer2);
        }
        
        RetailBusiness rb = new RetailBusinessImpl(customerRepository);
        rb.discountToCustomer(0.1);
        
        List<Customer> customers3= customerRepository.readCustomer();
        for (Customer customer2 : customers3){
            System.out.println(customer2);
        }
        
    }
}
