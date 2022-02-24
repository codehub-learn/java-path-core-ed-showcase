/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit
this template
 */
package gr.codelearn.core.showcase.store;

import gr.codelearn.core.showcase.oop.model.Product;
import java.math.BigDecimal;

/**
 *
 * @author iracl
 */
public interface Shop {
    void buy(Product product);
    void pay(BigDecimal amount);
}
