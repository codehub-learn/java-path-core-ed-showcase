/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.collection;

import java.util.Comparator;

public class CustomComparator implements Comparator<String>{

//    @Override
//    public int compare(String s0, String s1) {
//        // reverse ordering
//        return s1.compareTo(s0);
//    }
    
    @Override
    public int compare(String s0, String s1) {
        // ordering based on which string is longer
        return s1.length() - s0.length();
    }
    
}
