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
public class FileIO {

    public static void main(String[] args) {
        File fileDirectory = new File(Directory.FILE_DIRECTORY.getPath());
        System.out.println(fileDirectory.getAbsoluteFile());
        System.out.println(fileDirectory.getAbsolutePath());
        System.out.println(fileDirectory.getName());
        System.out.println(fileDirectory.getParent());
        System.out.println(fileDirectory.isDirectory());
        System.out.println(fileDirectory.isFile());
        System.out.println(fileDirectory.canExecute());
        System.out.println(fileDirectory.canRead());
        System.out.println(fileDirectory.canWrite());
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
        }
        File[] allSubFiles = fileDirectory.listFiles();
        for (File file : allSubFiles) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
        
        System.out.println("-------------");

        File[] txtFiles = fileDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
        
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getName());
        }
    }

}
