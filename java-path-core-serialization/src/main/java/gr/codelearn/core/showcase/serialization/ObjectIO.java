/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.serialization;

import gr.codelearn.core.showcase.serialization.domain.Customer;
import gr.codelearn.core.showcase.serialization.domain.Directory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageOutputStream;

/**
 *
 * @author mcjohn1
 */
public class ObjectIO {

    public static void main(String[] args) {
        writeObjectToFile();
        readObjectFromFile();
    }

    public static void writeObjectToFile() {
        try (FileOutputStream fos = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "object.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Customer customer = new Customer("Ioannis", "3rd Str.", 1970);
            oos.writeObject(customer);
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }
    }

    public static void readObjectFromFile() {
        try (FileInputStream fis = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + "object.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            Customer readObject = (Customer) ois.readObject();
            System.out.println(readObject);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        } 
    }

}
