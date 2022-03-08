package gr.codelearn.core.showcase.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalTimeDemo {

    public static void main(String[] args) {
        getValues();
        addAndSubtractTime();
        zones();
        durationInstantExample();
    }

    public static void getValues() {
        System.out.println("GET LOCAL TIME VALUES");
        LocalTime localTime = LocalTime.now();
        System.out.println("Current time is: " + localTime);
        System.out.println("Current minutes: " + localTime.getMinute());
        System.out.println("Current nanoseconds: " + localTime.getNano());
        System.out.println("Max time: " + LocalTime.MAX);
    }

    public static void addAndSubtractTime() {
        System.out.println("---------------------");
        System.out.println("ADD AND SUBTRACT TIME");
        LocalTime localTime = LocalTime.now();
        System.out.println("Current time: "+ localTime);
        System.out.println("One hour ago was: "+ localTime.minusHours(1));
        System.out.println("After thirty seconds: "+ localTime.plus(30,ChronoUnit.SECONDS) + " current time: "+LocalTime.now());
        LocalTime localTimeMidnight = LocalTime.parse("00:00");
        System.out.println(localTimeMidnight.minusMinutes(1));
    }
    
    public static void zones(){
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        LocalTime localTime = LocalTime.now();
        System.out.println("Current time: "+ localTime);
        System.out.println("LocalTime at Tokyo: "+ LocalTime.now(ZoneId.of("Asia/Tokyo")));
    }
    
    public static void durationInstantExample(){
        Instant now = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
        Instant later = Instant.now();
        Duration duration = Duration.between(now,later);
        System.out.println("LocalDateTime: "+ localDateTime);
        System.out.println("Now: "+ now);
        System.out.println("Later: "+ later);
        System.out.println("Duration: "+ duration);
    }
}
