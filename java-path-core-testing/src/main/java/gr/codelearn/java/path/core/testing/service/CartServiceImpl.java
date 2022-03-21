/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.testing.service;

import gr.codelearn.java.path.core.testing.domain.Item;
import gr.codelearn.java.path.core.testing.repository.CartRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mcjohn1
 */
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private BigDecimal balance;

    public CartServiceImpl(CartRepository cartRepository, BigDecimal balance) {
        this.cartRepository = cartRepository;
        this.balance = balance;
    }

    @Override
    public boolean addItem(Item item) {
        if (item.getQuantity() > 0) {
            return cartRepository.getItems().add(item);
        } else {
            return false;
        }
    }

    @Override
    public boolean removeItem(Item item) {
        return cartRepository.getItems().remove(item);
    }

    @Override
    public List<Item> getCart() {
        return cartRepository.getItems();
    }

    @Override
    public BigDecimal getTotalPrice() {
        // price * quantity
        // add all
        // reduce
        return cartRepository.getItems()
                .stream()
                .map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean checkout() {
        if (getTotalPrice().compareTo(balance) <= 0) {
            cartRepository.setItems(new ArrayList<>());
            return true;
        }
        return false;
    }

}
