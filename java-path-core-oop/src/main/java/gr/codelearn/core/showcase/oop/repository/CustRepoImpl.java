/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.repository;

import gr.codelearn.core.showcase.oop.model.Customer;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author iracl
 */
public abstract class CustRepoImpl implements CustomerRepository{

  
    private List<Customer> customers;
    private static int customerIds;
    public void   setCustomersList(List<Customer> customers) {
        this.customers = customers;
    }
     

    @Override
    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        customer.setId(++customerIds);
        return customer;
    }

    @Override
    public Customer readCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id && customer.isActive()) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> readCustomer() {
        return customers;
    }

    @Override
    public void updateCustomer(int customerId, String newAddress) {
        Customer customer = readCustomer(customerId);
        if (customer != null) {
            customer.setAddress(newAddress);
        }
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        Customer customer = readCustomer(customerId);
        if (customer != null) {
            customers.remove(customer);
            // customer.setActive(false);
        }
        return false;
    }
}
