/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.repository;

import gr.codelearn.core.showcase.oop.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iracl
 */
public class CustomerRepositoryArrayListImpl extends CustRepoImpl {

    private final List<Customer> customers = new ArrayList<>();
     
     public CustomerRepositoryArrayListImpl(){
          setCustomersList(customers);
     }
}
