/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.serialization.domain;

import java.io.*;

/**
 *
 * @author mcjohn1
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 2;

    private String name;
    private String address;
    private int yearOfBirth;
    private transient int age;

    public Customer(String name, String address, int yearOfBirth) {
        this.name = name;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", yearOfBirth=" + yearOfBirth + ", age=" + age + '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.name += "Encrypted";
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        name = name.substring(0, name.length() - 9);
    }

}
