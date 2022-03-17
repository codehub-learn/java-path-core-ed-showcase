/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate.repository;

import gr.codelearn.java.path.core.hibernate.model.Department;
import javax.persistence.EntityManager;

/**
 *
 * @author mcjohn1
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private EntityManager entityManager;

    public DepartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Department department) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();
        } catch (RuntimeException exception) {
            System.out.println(exception.getClass());
            System.out.println(exception.getMessage());
            // needs refactoring, may throw transaction inactive exception
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Department read(long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public void delete(Department department) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(department);
            entityManager.getTransaction().commit();
        } catch (RuntimeException exception) {
            System.out.println(exception.getClass());
            System.out.println(exception.getMessage());
            // needs refactoring, may throw transaction inactive exception
            entityManager.getTransaction().rollback();
        }
    }

}
