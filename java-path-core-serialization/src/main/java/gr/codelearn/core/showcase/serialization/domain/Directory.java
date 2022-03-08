/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.serialization.domain;

import java.io.File;

/**
 *
 * @author mcjohn1
 */
public enum Directory {
    FILE_DIRECTORY(System.getProperty("user.home") + File.separator + "data_files" + File.separator);
    
    private final String path;

    private Directory(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
