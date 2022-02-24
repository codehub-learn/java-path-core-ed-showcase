/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.usecases;

import gr.codelearn.core.showcase.oop.model.Laptop;
import gr.codelearn.core.showcase.oop.model.Product;
import gr.codelearn.core.showcase.store.GreenShop;
import gr.codelearn.core.showcase.store.RedShop;
import gr.codelearn.core.showcase.store.Shop;

/**
 *
 * @author iracl
 */
public class Market {
    
    
    private Shop shop = new GreenShop();
    
    public void transactions(){
        Product p = new Laptop();
        shop.buy(p);
    }
    
}
