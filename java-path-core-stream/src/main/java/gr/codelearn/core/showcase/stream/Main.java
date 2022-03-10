/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //streamCreateActions();
        //streamBasicActions();
        streamIntermediateActions();
    }

    private static void streamCreateActions() {
        Stream<Object> empty = Stream.empty();

        Stream<Object> builtStream = Stream.builder()
                .add("First")
                .add("Second")
                .add("Three")
                .build();

        Stream<String> generatedStream = Stream.generate(() -> "10").limit(10);
        //generatedStream.forEach(s -> System.out.println(s));
        generatedStream.forEach(System.out::println);
        System.out.println("----------");
        //generatedStream.forEach(System.out::println);
        System.out.println("HELLO");

        System.out.println("----------");

        Stream<Integer> iterationStream = Stream.iterate(40, i -> ++i).limit(10);
        iterationStream.forEach(System.out::println);

        System.out.println("----------");

        IntStream rangeStream = IntStream.range(1, 20);
        rangeStream.forEach(System.out::println);

        System.out.println("----------");

        IntStream rangeCloseStream = IntStream.rangeClosed(1, 20);
        rangeCloseStream.forEach(System.out::println);
    }

    private static void streamBasicActions() {
        List<String> nameList1 = getNameList();
        nameList1.stream().sorted().forEach(System.out::println);

        System.out.println("----------");

        List<String> nameList2 = getNameList();

        //Stream.concat(nameList1.stream(), nameList2.stream()).sorted().forEach(System.out::println);
        Stream<String> concatenation1 = Stream.concat(nameList1.stream(), nameList2.stream());
        Stream<String> concatenation2 = Stream.concat(nameList1.stream(), nameList2.stream());
        Stream.concat(concatenation1, concatenation2).sorted().forEach(System.out::println);
    }

    private static void streamIntermediateActions() {
        List<String> forFilter = getNameList();
        forFilter.stream().filter(name -> name.endsWith("os")).forEach(System.out::println);

        System.out.println("----------");

        List<String> forLimit = getNameList();
        forLimit.stream().sorted().limit(3).forEach(System.out::println);

        System.out.println("----------");

        List<String> forSkip = getNameList();
        forSkip.stream().sorted().skip(3).forEach(System.out::println);

        System.out.println("----------");

        List<String> forDistinct = getNameList();
        forDistinct.stream().sorted().distinct().forEach(System.out::println);

        System.out.println("----------");

        List<String> forCustomSorted = getNameList();
        forCustomSorted.stream().sorted((n1, n2) -> n1.length() - n2.length()).forEach(System.out::println);

        System.out.println("----------");

        getNameList().stream()
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(String::valueOf)
                )
                .forEach(System.out::println);

    }

    public static void streamFinalActions() {

        // ForeachOrdered
        Stream<String> foreachOrderedStream = Stream.of("John", "Costas", "Costas", "Nick", "John", "Costas");
        System.out.println("ForeachOrdered example");
        System.out.println("----------");
        foreachOrderedStream.distinct().forEachOrdered(System.out::println);

        // Collect to Set
        Stream<String> collectSetStream = Stream.of("John", "Costas", "Costas", "Nick", "John", "Costas");
        System.out.println("Collect to Set example");
        System.out.println("----------");
        Set<String> set = collectSetStream.collect(Collectors.toSet());

        // Collect to List
        Stream<String> collectListStream = Stream.of("John", "Costas", "Costas", "Nick", "John", "Costas");
        System.out.println("----------");
        List<String> list = collectListStream.collect(toList());
        list.forEach(System.out::println);

        // Collect to general collections
        Stream<String> collectGeneralCollectionsStream = Stream
                .of("John", "Costas", "Costas", "Nick", "John", "Costas");
        System.out.println("Collect to general collections example");
        System.out.println("----------");
        //collectGeneralCollectionsStream.collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);    

    }

    private static List<String> getNameList() {
        return List.of("Spyros",
                "Chris",
                "Chris",
                "Giannis",
                "Alexandros",
                "Menelaos",
                "Menelaos",
                "John",
                "Nick");
    }

    private static void basedOnPresentation() {
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
            if (string.length() > 4 && string.startsWith("G")) {
                System.out.println(string);
            }
        }

        System.out.println("-----------------------");

        asList.sort((name1, name2) -> name1.length() - name2.length());

        asList
                .stream()
                .filter(name -> name.length() > 4)
                //.filter(name -> name.startsWith("G"))
                .map(String::length) // method reference (from the String class, call the length method for each element)
                .forEach(name -> System.out.println(name));

        Predicate p;
        Function f;
        Comparator c;
        Consumer con;
    }

}
