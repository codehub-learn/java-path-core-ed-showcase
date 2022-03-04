/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.service;

import gr.codelearn.core.showcase.oop.model.Customer;
import gr.codelearn.core.showcase.oop.repository.CustomerRepository;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 *
 * @author iracl
 */
@AllArgsConstructor
public class RetailBusinessImpl implements RetailBusiness{
    private CustomerRepository customerRepo;
    
   
    @Override
    public void discountToCustomer(double rate) {
 
            List<Customer> customers = customerRepo.readCustomer();
            for(Customer customer:customers)
                customer.setBalance( (1-rate)* customer.getBalance());
    }
    
}
