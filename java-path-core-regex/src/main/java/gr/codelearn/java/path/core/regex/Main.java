/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mcjohn1
 */
public class Main {

    public static void main(String[] args) {
        //originalExample();
        //lazyVsGreedy();
        matcherGroups();
    }

    public static void lazyVsGreedy() {
        String sentece = "<h1>News</h1>";
        String pattern = "<.*?>";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(sentece);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        System.out.println(matcher.find());
        System.out.println(matcher.group());
    }

    public static void originalExample() {
        String sentence = "Greece and the greeks of the ancient world";
        String pattern = "^Greece$?.*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(sentence);
        System.out.println(matcher.matches());
        System.out.println(matcher.group());
        //System.out.println(matcher.find());
    }

    public static void matcherGroups() {
        String sentence = "For me, 2021 was okay, but 2022 will be even better 2b";
        String pattern = "";
        String patternGrouped = "(.+?) (\\d+) (.+?)";

        Pattern compiledPattern = Pattern.compile(patternGrouped);
        Matcher matcher = compiledPattern.matcher(sentence);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        //System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        //System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.find());
    }
}
