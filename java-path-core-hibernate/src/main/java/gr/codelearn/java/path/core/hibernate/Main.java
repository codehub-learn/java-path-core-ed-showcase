/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate;

import gr.codelearn.java.path.core.hibernate.model.Department;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mcjohn1
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UniversityPU");
        EntityManager entityManager = emf.createEntityManager();
        //entityManager.find(Department.class, 1L);

        Department department = new Department();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();
        } catch (RuntimeException exception){
            entityManager.getTransaction().rollback();
        }
        System.out.println(department.getId());

    }

}
