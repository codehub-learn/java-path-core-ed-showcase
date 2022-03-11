/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //streamCreateActions();
        //streamBasicActions();
        //streamIntermediateActions();
        streamFinalActions();
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

        System.out.println("");

        // Collect to List
        Stream<String> collectListStream = Stream.of("John", "Costas", "Costas", "Nick", "John", "Costas");
        System.out.println("----------");
        List<String> list = collectListStream.collect(toList());
        list.forEach(System.out::println);

        System.out.println("");

        // Collect to general collections
        Stream<String> collectGeneralCollectionsStream = Stream
                .of("John", "Costas", "Costas", "Nick", "John", "Costas");
        System.out.println("Collect to general collections example");
        System.out.println("----------");
        collectGeneralCollectionsStream.collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);

        System.out.println("");

        System.out.println("Collect to string array");
        System.out.println("----------");
        List<String> collectToArray = getNameList();
        String[] toStringArray = collectToArray.stream().toArray(String[]::new);

        System.out.println("");

        System.out.println("Collect to map");
        System.out.println("----------");
        List<String> collectToMap = getNameList();
//        Map<String, Character> collectedMap = 
        collectToMap.stream().distinct()
                .collect(Collectors.toMap(Function.identity(), name -> (int) name.chars().distinct().count()))
                .forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("");

        System.out.println("Collect grouping by");
        System.out.println("----------");
        List<String> groupingByExample = getNameList();
        groupingByExample.stream().distinct().filter(name -> !name.endsWith("is")).sorted().collect(Collectors.groupingBy(name -> name.charAt(0))).forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("");
        
        System.out.println("Collect grouping by (ordered map)");
        System.out.println("----------");
        // The following block of code was asked within class, but was left 
        // somewhat unanswered (how to sort a map)
        // here is a link for it:
        // https://www.baeldung.com/java-hashmap-sort
        // and one of its implementations through streams:
        Map<Character, List<String>> unorderedGroupingByMap = groupingByExample.stream().distinct().filter(name -> !name.endsWith("is")).sorted().collect(Collectors.groupingBy(name -> name.charAt(0)));

        unorderedGroupingByMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, List<String>>comparingByKey())
                .forEach(System.out::println);

        System.out.println("");

        System.out.println("Reduce example");
        System.out.println("----------");
        List<Invoice> listOfInvoices = List.of(new Invoice(5, new BigDecimal("10"), "001"), new Invoice(2, new BigDecimal("20"), "002"), new Invoice(1, new BigDecimal("40"), "003"));
//        int result = 0;
//        for (Invoice invoice : listOfInvoices) {
//            result += invoice.getPrice() * invoice.getQuantity();
//        } 
        // With big decimal 
        BigDecimal result = listOfInvoices.stream().map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
        // Without big decimal (with primitives)
        Double result1 = listOfInvoices.stream().map(i -> i.getPrice().doubleValue() * i.getQuantity()).reduce(0.0, (r1, r2) -> r1 + r2);
        System.out.println(result1);

        System.out.println("");

        // The following were not seen in class, but mentioned. Nevertheless, here
        // are some implementations:
        //  summarizing double
        System.out.println("Summarizing double example");
        System.out.println("----------");
        List<String> collectSummarizingDouble = getNameList();
        DoubleSummaryStatistics collectSummarizingDoubleResult
                = collectSummarizingDouble.stream()
                        .distinct()
                        .collect(
                                summarizingDouble(s -> s.length()));
        System.out.println("Average: " + collectSummarizingDoubleResult.getAverage());
        System.out.println("Sum: " + collectSummarizingDoubleResult.getSum());
        System.out.println("Count: " + collectSummarizingDoubleResult.getCount());
        System.out.println("Min: " + collectSummarizingDoubleResult.getMin());
        System.out.println("Max: " + collectSummarizingDoubleResult.getMax());

        System.out.println("");

        //  joining
        System.out.println("Joining");
        System.out.println("----------");
        List<String> joiningList = getNameList();
        String joiningResult = joiningList.stream().distinct().sorted().collect(
                Collectors.joining(" ", "Names: ", "."));
        System.out.println(joiningResult);

        System.out.println("");

        // partioning by
        System.out.println("Partitioning by");
        System.out.println("----------");
        List<String> collectPartitioningBy = getNameList();
        Map<Boolean, List<String>> collectPartitioningByMap
                = collectPartitioningBy.stream()
                        .distinct()
                        .sorted()
                        .collect(partitioningBy(s -> s.length() > 5));
        System.out.println(collectPartitioningByMap);
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
                "Nick",
                "Janathan",
                "Joana");
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
            "Nick",};

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
