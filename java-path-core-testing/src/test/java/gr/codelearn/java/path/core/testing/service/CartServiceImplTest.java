/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package gr.codelearn.java.path.core.testing.service;

import gr.codelearn.java.path.core.testing.domain.Item;
import gr.codelearn.java.path.core.testing.repository.CartRepository;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mcjohn1
 */
public class CartServiceImplTest {

    private CartService cartService;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("before all");

    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("after all");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("before method");
        CartRepository cartRepository = new CartRepository();
        BigDecimal balance = BigDecimal.valueOf(500);
        cartService = new CartServiceImpl(cartRepository, balance);
        cartService.addItem(new Item("Potato", BigDecimal.valueOf(5), 15));
        cartService.addItem(new Item("iPhone", BigDecimal.valueOf(250), 1));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("after method");
    }

    @Test
    public void itemShouldNotBeAddedIfZeroQuantity() {
        Item itemWith0Quantity = new Item("Tomato", BigDecimal.valueOf(5000), 0);
        assertFalse(cartService.addItem(itemWith0Quantity), "Item should not be added, method should return false");
    }

    @Test
    public void alwaysFails() {
        fail(); // i.e., used for conditions/branches
    }

    @Test
    public void assertAll() {
        Item itemWith0Quantity = new Item("Tomato", BigDecimal.valueOf(5000), 1);
        Assertions.assertAll(() -> assertTrue(cartService.addItem(itemWith0Quantity), "Item should be added as expected"),
                () -> assertEquals(3, cartService.getCart().size(), "Size should be equal to 3"));
    }

}
