package gr.codelearn.core.showcase.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {

    public static void main(String[] args) {
        getValues();
        addAndSubtractDate();
        parseDate();
    }

    public static void getValues() {
        System.out.println("GET LOCAL DATE VALUES");
        LocalDate localDate = LocalDate.now();
        System.out.println("Current date: " + localDate);
        System.out.println("Current day of month: " + localDate.getDayOfMonth());
        System.out.println("Current day of week: " + localDate.getDayOfWeek());
        System.out.println("Current year: " + localDate.getYear());
    }

    public static void addAndSubtractDate() {
        System.out.println("---------------------");
        System.out.println("ADD AND SUBTRACT DATES");
        LocalDate localDate = LocalDate.now();
        System.out.println("Today is: " + localDate);
        System.out.println("Yesterday was: " + localDate.minusDays(1));
        System.out.println("One month later will be: " + localDate.plus(1, ChronoUnit.MONTHS));
    }

    public static void parseDate() {
        System.out.println("---------------------");
        System.out.println("PARSE DATES");
        LocalDate christmasNumeric = LocalDate.of(LocalDate.now().getYear(),12,25);
        System.out.println("The day of Christmas for "+christmasNumeric.getYear()+" is "+christmasNumeric.getDayOfWeek());
        LocalDate christmasEnum = LocalDate.of(LocalDate.now().getYear(),Month.DECEMBER,25);
        LocalDate christmasText = LocalDate.parse("2022-12-25");
    }
}
