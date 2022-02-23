package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Laptop;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setSerial("LP50X22");
        laptop.setName("ThinkBook");
        laptop.setPrice(new BigDecimal("700.50"));
     
        System.out.println("Laptop serial: "+ laptop.getSerial());
        System.out.println("Laptop name: "+ laptop.getName());
        System.out.println("Laptop price: "+ laptop.getPrice());
        System.out.println(laptop);
        
        Laptop laptop2 = new Laptop(4,"LP30x21","Inspitation",new BigDecimal("200"));
        System.out.println(laptop2);
        
    }
}
