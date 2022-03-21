/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.testing.repository;

import gr.codelearn.java.path.core.testing.domain.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mcjohn1
 */
public class CartRepository {
    private List<Item> items = new ArrayList<>();

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    } 
    
    
}
