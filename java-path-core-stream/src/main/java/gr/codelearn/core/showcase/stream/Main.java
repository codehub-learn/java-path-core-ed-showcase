/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] namesArray = {
            "Spyros",
            "Chris",
            "Chris",
            "Giannis",
            "Alexandros",
            "Menelaos",
            "John",
            "Nick"
        };
        
        Stream.of(namesArray);
        
        Stream.of("Name1", "Name2");
        
        List<String> asList = Arrays.asList(namesArray);
        
        for (String string : asList) {
            if(string.length() > 4 && string.startsWith("G")){
                System.out.println(string);
            }
        }
        
        System.out.println("-----------------------");
        
        asList
                .stream()
                .filter(name -> name.length() > 4)
                //.filter(name -> name.startsWith("G"))
                .map(name -> name.length())
                .forEach(name -> System.out.println(name));
        Predicate p;
        Function f;
    }
}
