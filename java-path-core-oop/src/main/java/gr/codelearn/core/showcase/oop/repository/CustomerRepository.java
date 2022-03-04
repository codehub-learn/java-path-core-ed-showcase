/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.repository;

import gr.codelearn.core.showcase.oop.model.Customer;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface CustomerRepository {
    //CRUD
     Customer createCustomer(Customer customer);
     Customer readCustomer(int id) ;
     List<Customer> readCustomer();
     void updateCustomer(int customerId, String newAddress);
     boolean deleteCustomer(int customerId);
}
