/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author iracl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bag {
    
//    public static final String RETAIL_SALES = "retail sales";
//    public static final String GROSS_SALES = "gross sales";
//    public static final String RANDOM_SALES = "random sales";
    
    
    private ImmutableProduct product;
    private Customer customer;
    private SalesType type;
}
