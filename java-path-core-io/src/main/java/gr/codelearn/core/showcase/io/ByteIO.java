/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.io;

import gr.codelearn.core.showcase.io.domain.Directory;
import java.io.*;


/**
 *
 * @author mcjohn1
 */
public class ByteIO {

    public static void main(String[] args) {
        writeBytesToFile();
        readBytesFromFile();
        System.out.println(Directory.FILE_DIRECTORY.getClass());
    }

    public static void writeBytesToFile() {
        try (FileOutputStream fos = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt", true)) {       
            String text = "Hello";
            fos.write(text.getBytes());
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
        }
    }

    public static void readBytesFromFile() {
        try (FileInputStream fis = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt")) {
            fis.skip(1);
            int readByte;

            while ((readByte = fis.read()) != -1) {
                System.out.println(readByte);
            }

            System.out.println("Reading has finished...");
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }
    }
    
    public static void writeBytesToFileWithBuffer() {
        try (FileOutputStream fos = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt", true);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {       
            String text = "Hello";
            bos.write(text.getBytes());
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
        }
    }
    
    public static void readBytesFromFileWithBuffer() {
        try (FileInputStream fis = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt");
                BufferedInputStream bis = new BufferedInputStream(fis)) {
            bis.skip(1);
            int readByte;

            while ((readByte = bis.read()) != -1) {
                System.out.println(readByte);
            }

            System.out.println("Reading has finished...");
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }
    }
    
    public static void writeBytesToFileTryCatchFinally() {
        // bad to use, never do it, prefer try-with-resources
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "byteTest.txt", true);
            String text = "Heyyyy";
            fos.write(text.getBytes());
        } catch (IOException ex) {
            System.out.println("Something went wrong while writing.");
            System.out.println(ex.getMessage());
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("Something went wrong while writing.");
                System.out.println(ex.getMessage());
            }
        }
    }
}
