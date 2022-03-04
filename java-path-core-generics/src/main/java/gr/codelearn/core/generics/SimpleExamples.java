package gr.codelearn.core.generics;

import java.util.ArrayList;
import java.util.List;

public class SimpleExamples {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("String");
        list.add("String2");
//        list.add(1); Runtime exception

        for (Object object : list) {
            String s1 = (String) object;
            System.out.println("The sting value is: " + s1);
        }

        List<String> listString = new ArrayList<>();
        listString.add("A string");
        listString.add("A string 2");
//        listString.add(1); Cannot compile

        Generic<String, Integer> genericString = new Generic<>();
        genericString.addToList("String");

        Generic<Boolean, Float> genericInteger = new Generic<>();
        genericInteger.addToList(true);
        System.out.println(genericInteger.getListSize());

        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(1.5);

        Generic<A, String> variable1 = new Generic<>();
        Generic<B, String> variable2 = new Generic<>();
        something(variable1);
//        something(variable2); Cannot compile Generic<B,String> does not extends Generic<A,String>

        upperBoundExample();

    }

    public static void upperBoundExample() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        System.out.println("The mean of the integerList is: " + calculateMean(integerList));

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(5.5);
        doubleList.add(10.5);
        doubleList.add(12.5);
        System.out.println("The mean of the doubleList is: " + calculateMean(doubleList));
    }

    public static double calculateMean(List<? extends Number> numbers) {
        if (!numbers.isEmpty()) {
            double sum = 0;
            for (Number number : numbers) {
                sum += number.doubleValue();
            }
            return sum / numbers.size();
        } else {
            return 0;
        }
    }

    public static void lowerBoundExample() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);

        List<Number> numberList = new ArrayList<>();
        numberList.add(5);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(5.5);
        
        List<? super Integer> lowerBoundList;
        lowerBoundList = integerList;
        lowerBoundList = numberList;
//        lowerBoundList = doubleList; Due to lower bound we cannot assign doubleList
    }

    class A {

    }

    class B extends A {

    }

    public static void something(Generic<A, String> a) {

    }

}
