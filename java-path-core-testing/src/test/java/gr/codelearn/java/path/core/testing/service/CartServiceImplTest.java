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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author mcjohn1
 */
@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    private CartService cartService;
    
    @Mock
    private PaymentService mockedPaymentService;

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
        cartService = new CartServiceImpl(cartRepository, mockedPaymentService);
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
    
    @Test
    public void checkout(){
        when(mockedPaymentService.balance()).thenReturn(BigDecimal.valueOf(500));
        boolean isCompleted = cartService.checkout();
        int numOfCartItems = cartService.getCart().size();
        Assertions.assertAll(()->assertTrue(isCompleted,"Checkout is NOT completed successfully"),
                             ()->assertEquals(0,numOfCartItems,"Cart is NOT empty")
        );
        verify(mockedPaymentService).withdraw(BigDecimal.valueOf(325));
    }
    
    @Test
    public void checkoutError(){
        when(mockedPaymentService.balance()).thenReturn(BigDecimal.valueOf(100));
        boolean isCompleted = cartService.checkout();
        int numOfCartItems = cartService.getCart().size();
        Assertions.assertAll(()->assertFalse(isCompleted,"Checkout is completed successfully"),
                             ()->assertEquals(2,numOfCartItems,"Cart is NOT empty")
        );
        verify(mockedPaymentService, never()).withdraw(BigDecimal.valueOf(325));
    }

}
