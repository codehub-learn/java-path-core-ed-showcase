/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.exception;

import gr.codelearn.core.showcase.exception.exception.BusinessException;
import gr.codelearn.core.showcase.exception.exception.IncorrectPasswordException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcjohn1
 */
public class ExceptionMechanismTester {
    public static void main(String[] args) {
        //noExceptionHandling();
            //System.out.println(basicExceptionHandling());
            //System.out.println(advancedExceptionHandling());
            //throwsExceptionUncheckedException();
//        try {
//            
//            throwsExceptionCheckedException();
//        } catch (FileNotFoundException ex) {
//            System.out.println("file not found");
//        }
//        try {  
//            register();
//        } catch (BusinessException ex) {
//            System.out.println("cannot register with message");
//            System.out.println(ex.getMessage());
//        }
            classCastExceptionShowcase();
            
    }
    
    public static void noExceptionHandling(){
        Integer.parseInt("5a");
        System.out.println("All good!");
    }
    
    public static int basicExceptionHandling(){
        try {
            int x = Integer.parseInt("5a");
            System.out.println("All good!");
            return 1;
        } catch(NumberFormatException e) {
            System.out.println("Error occured:");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getClass());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
            return 2;
        }
    }
    
    public static int advancedExceptionHandling(){
        try {
            System.out.println("Starting parsing...");
            int x = Integer.parseInt("5a");
            System.out.println("All good!");
            System.out.println("use");
            return 1;
        } catch(NullPointerException e) {
            System.out.println("Error occured:");
            System.out.println(e.getMessage());
            return 2;
        } finally {
            System.out.println("Finally block executed");
            //return -1; // <----------------- never do that   
        }
    }
    
    public static void throwsExceptionUncheckedException() throws NumberFormatException {
        System.out.println("Surely nothing will go wrong...");
        int x = Integer.parseInt("5a");
    }
    
    public static void throwsExceptionCheckedException() throws FileNotFoundException {
        FileReader fileReader = new FileReader("...");
    }
    
    public static void readFileTest() {
        try {
            FileReader fileReader = new FileReader("...");
        } catch (FileNotFoundException ex) {
            System.out.println("cannot read file");
        }
    }
    
    public static void register() throws IncorrectPasswordException {
        int x = 5;
        if(x > 1){
            throw new IncorrectPasswordException("wrong password, please input the correct one");
        }
    }
    
    
    public static void classCastExceptionShowcase(){
        BusinessException businessException = new BusinessException("test123");
        IncorrectPasswordException incorrect = (IncorrectPasswordException) businessException;
    }
}
