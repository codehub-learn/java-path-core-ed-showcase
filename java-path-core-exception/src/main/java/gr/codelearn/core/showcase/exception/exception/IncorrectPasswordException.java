/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.exception.exception;

/**
 *
 * @author mcjohn1
 */
public class IncorrectPasswordException extends BusinessException { 
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
