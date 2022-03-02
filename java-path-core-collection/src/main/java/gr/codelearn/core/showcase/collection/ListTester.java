/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.collection;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.*;

public class ListTester {

    public static void main(String[] args) {
        //listCreation();
        //varArgsShowcase();
        //listSorting();
        linkedListExamples();
    }

    private static void listCreation() {
        ArrayList<String> list = new ArrayList<>(10);
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);

        // for turning a number of elements to an immutable list
        List<String> immutableStringList = List.of("1st", "2nd", "3rd");

        // for turning an array to an immutable list
        String[] strings = generateRandomStrings(17);
        List<String> immutableStrings = List.of(strings);

        // for turning a mutable list to immutable
        ArrayList<String> listOfStrings = new ArrayList<>();
        ArrayList<String> copiedImmutableList = (ArrayList<String>) List.copyOf(listOfStrings);

        List<Object> emptyList = Collections.emptyList();
    }

    private static void listSorting() {
        String[] strings = generateRandomStrings(15);

        // both methods will throw exception:
        //immutableStrings.set(1, "test");
        //immutableStrings.sort(null);
        List<String> list = Arrays.asList(strings);
        list.sort(null);
        for (String string : list) {
            System.out.println(string);
        }
    }

    private static void linkedListExamples() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Ioannis");
        linkedList.add("Vasilis");
        linkedList.add("Alexandra");
        linkedList.add("Manos");
        linkedList.pop();
        //linkedList.offer()

        for (String string : linkedList) {
            System.out.println(string);
        }
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.size());

        linkedList.peek();

    }

    private static void varArgsShowcase(Integer key, String... strings) {
        System.out.println(strings.length);
        System.out.println(strings[1]);
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
}
