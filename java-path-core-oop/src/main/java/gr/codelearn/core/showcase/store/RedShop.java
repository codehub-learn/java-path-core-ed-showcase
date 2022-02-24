/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.store;

import gr.codelearn.core.showcase.oop.model.Product;
import java.math.BigDecimal;

/**
 *
 * @author iracl
 */
public class RedShop implements Shop {
    private BigDecimal balance =   BigDecimal.ZERO ;

   
    
    @Override
    public void buy(Product product) {
        System.out.println("The product "+ product.getName()+ " has been bought");
     }

    @Override
    public void pay(BigDecimal amount) {
        if (amount == null){
            System.out.println("The amount was null");
        }
        else{
            balance.add(amount);
            System.out.println("The payment "+ amount + " has been paid");
        }
    }
 }
