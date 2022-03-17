/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate.repository;

/**
 *
 * @author mcjohn1
 */
public interface CRUDRepository<T> {
    
    void save(T t);
    T read(long id); // change read to get
    void delete(T t); // change delete to remove (?)
    
}
