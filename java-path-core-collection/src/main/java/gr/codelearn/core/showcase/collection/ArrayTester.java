/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.collection;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayTester {

    final static private String LINE_SEPARATOR = "_________________________";

    public static void main(String[] args) {
        arrayCreation();
        arrayDefaultValues();
        stringArrayActions();
        otherArrayActions();
    }

    private static void arrayDefaultValues() {
        // Default values for int
        int[] myArray = new int[25];
        System.out.println(myArray.length);
        for (int i = 0; i < myArray.length; i++) {
            int j = myArray[i];
        }
        
        System.out.println(LINE_SEPARATOR);

        // Default values for string
        String[] myStringAr = new String[5];
        String myResult = "Test ";
        StringBuilder myStringBuilder = new StringBuilder();
        myStringBuilder.append(myResult);
        for (int i = 0; i < myStringAr.length; i++) {
            myStringBuilder.append(myStringAr[i]).append(" ");
        }
        System.out.println(myStringBuilder);
        
        System.out.println(LINE_SEPARATOR);

        // Default values for double
        double[] myArrayDouble = new double[25];
        for (int i = 0; i < myArrayDouble.length; i++) {
            System.out.println(myArrayDouble[i]);
        }
        
        System.out.println(LINE_SEPARATOR);

        // Default values for boolean
        boolean[] myArrayBoolean = new boolean[25];
        for (int i = 0; i < myArrayBoolean.length; i++) {
            System.out.println(myArrayBoolean[i]);
        }
    }

    private static void arrayCreation() {
        // the old way
        int[] setNumbersArOld = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // newer way
        int[] setNumbersAr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : setNumbersAr) {
            System.out.println(i);
        }
        
        System.out.println(LINE_SEPARATOR);

        // string example
        String[] myStrAr = {"test", "test2", "test3"};
        for (int i = myStrAr.length - 1; i >= 0; i--) {
            System.out.println(myStrAr[i]);
        }
        
        System.out.println(LINE_SEPARATOR);

        // 2dimensional example
        int[][] twoDimensionalArray = new int[10][10];
        int[][] intArray2D = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {1, 1}};

        // first way to iterate 2d
        for (int i = 0; i < intArray2D.length; i++) {
            int[] is = intArray2D[i];
            for (int j = 0; j < is.length; j++) {
                System.out.println(is[j]);
            }
            System.out.println("-----1ST WAY------");
        }

        // second way to iterate 2d
        for (int i = 0; i < intArray2D.length; i++) {
            for (int j = 0; j < intArray2D[i].length; j++) {
                System.out.println(intArray2D[i][j]);
            }
            System.out.println("-----2ND WAY------");
        }

        // array cloning (remember shallow vs deep)
        int[] clonedCopy = setNumbersAr.clone();
        System.out.println(clonedCopy == setNumbersAr);
        System.out.println(setNumbersAr.equals(clonedCopy));
        System.out.println(Arrays.equals(clonedCopy, setNumbersAr));

    }

    private static void stringArrayActions() {
        String[] randomCities = generateRandomStrings(10);
        for (String city : randomCities) {
            System.out.println(city);
        }

        System.out.println(LINE_SEPARATOR);

        // copy of example
        String[] copiedCities = Arrays.copyOf(randomCities, 10);
        for (String copiedCity : copiedCities) {
            System.out.println(copiedCity);
        }
        System.out.println(randomCities == copiedCities);
        System.out.println(randomCities.equals(copiedCities));
        System.out.println(Arrays.equals(randomCities, copiedCities));

        System.out.println(LINE_SEPARATOR);

        // range copy example
        String[] copyOfRangeCities = Arrays.copyOfRange(randomCities, 0, randomCities.length);
        for (String copyOfRangeCity : copyOfRangeCities) {
            System.out.println(copyOfRangeCity);
        }

        System.out.println(LINE_SEPARATOR);

        // natural sorting
        Arrays.sort(randomCities);
        for (String city : randomCities) {
            System.out.println(city);
        }

        // natural sorting of "string numbers"
        String[] randomNumbers = generateNumbers(20);
        Arrays.sort(randomNumbers);
        for (String numberStr : randomNumbers) {
            System.out.println(numberStr);
        }

        System.out.println(LINE_SEPARATOR);

        // sorting with our custom comparator class
        Arrays.sort(copiedCities, new CustomComparator());
        for (String copiedCity : copiedCities) {
            System.out.println(copiedCity);
        }

        System.out.println(LINE_SEPARATOR);

        // sorting with anonymous inner class
        String[] randomCities2 = generateRandomStrings(10);
        Arrays.sort(randomCities2, new Comparator<String>() {
            @Override
            public int compare(String s0, String s1) {
                return s0.compareToIgnoreCase(s1);
            }
        });
        for (String randomCity : randomCities2) {
            System.out.println(randomCity);
        }
        
        System.out.println(LINE_SEPARATOR);

        // sorting the new way
        Arrays.sort(randomCities, (s1, s2) -> s2.compareTo(s1));

        // remember about capital vs non-capital letters & sorting
        String[] names = {"John", "Mike", "john", "Alexandra", "Nikos"};
        Arrays.sort(names);
        for (String name : names) {
            System.out.println(name);
        }

    }

    private static void otherArrayActions() {
        // filling array with a value
        var fillableArray = new int[10];
        Arrays.fill(fillableArray, 10);
        for (int i : fillableArray) {
            System.out.println(i);
        }

        // binary search example
        int[] odds = {1, 3, 5, 7, 9, 11};
        System.out.println(Arrays.binarySearch(odds, 3));
        System.out.println(Arrays.binarySearch(odds, 11));
        System.out.println(Arrays.binarySearch(odds, 6));

        // binary search example with unsorted array
        int[] unsorted = {9, 9, 111, 3, 5, 15};
        System.out.println(Arrays.binarySearch(unsorted, 115));
    }

    // indepedent 3rd party library
    private static String[] generateRandomStrings(int howMany) {
        // the generator could be declared once and not every time 
        // this method is called
        Lorem generator = LoremIpsum.getInstance();
        String[] cities = new String[howMany];
        for (int i = 0; i < howMany; i++) {
            cities[i] = generator.getCity();
        }
        return cities;
    }

    // https://www.baeldung.com/java-thread-local-random
    private static String[] generateNumbers(int howMany) {
        String[] numbers = new String[howMany];
        for (int i = 0; i < howMany; i++) {
            int unboundedRandomValue = ThreadLocalRandom.current().nextInt();
            numbers[i] = Integer.toString(unboundedRandomValue);
        }
        return numbers;
    }

}
