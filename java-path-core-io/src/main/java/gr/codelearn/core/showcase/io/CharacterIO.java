/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.io;

import gr.codelearn.core.showcase.io.domain.Directory;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mcjohn1
 */
public class CharacterIO {
    public static void main(String[] args) {
        
    }
    
    public static void writeCharactersToFile() {
        try (FileWriter fw = new FileWriter(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt", true)) {       
            String text = "Hello";
            fw.write(text);
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
        }
    }

    public static void readCharactersFromFile() {
        try (FileReader fis = new FileReader(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt")) {
            fis.skip(1);
            int readCharacter;

            while ((readCharacter = fis.read()) != -1) {
                System.out.println(readCharacter);
            }

            System.out.println("Reading has finished...");
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }
    }
    
    public static void writeCharactersToFileWithBuffer() {
        try (FileWriter fw = new FileWriter(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt", true);
                BufferedWriter bw = new BufferedWriter(fw)) {       
            String text = "Hello";
            bw.write(text);
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
        }
    }
    
}
