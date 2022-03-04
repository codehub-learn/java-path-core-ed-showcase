/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author iracl
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String customerName;
    private String customerSurname;
    private String address;
    private Date dateOfBirth;
    private boolean active = true;
    private double balance;
 }
