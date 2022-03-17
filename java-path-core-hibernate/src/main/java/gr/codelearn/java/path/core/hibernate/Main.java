/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate;

import gr.codelearn.java.path.core.hibernate.model.Department;
import gr.codelearn.java.path.core.hibernate.model.Student;
import gr.codelearn.java.path.core.hibernate.model.Unit;
import gr.codelearn.java.path.core.hibernate.model.UnitType;
import gr.codelearn.java.path.core.hibernate.repository.DepartmentRepository;
import gr.codelearn.java.path.core.hibernate.repository.DepartmentRepositoryImpl;
import java.time.LocalDate;
import java.util.List;
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

        Student student = new Student();
        student.setName("Ioannis");
        student.setAddress("Athens 15");
        student.setEmail("ioannis@codehub.gr");
        student.setDateRegistered(LocalDate.parse("2023-04-01"));

        System.out.println(student);

        Unit unit = new Unit();
        unit.setName("Introduction to Algorithms");
        unit.setNumberOfCredits(11);
        unit.setSupervisor("Dimi Irac");
        unit.setUnitType(UnitType.Lab);

        //Department department = new Department();
        Department department
                = new Department.Builder()
                        .setName("Computer Science")
                        .setUniversityName("MIT")
                        .setStudents(List.of(student))
                        .setUnits(List.of(unit))
                        .build();
        student.setDepartment(department);
        unit.setDepartment(department);

        
       
        System.out.println("---------------------");

        System.out.println(department);
        
        entityManager.clear();

        System.out.println("____________________");
        Department foundDepartment = entityManager.find(Department.class, 1L);
        System.out.println("____________________");
        for (Student s1 : foundDepartment.getStudents()) {
            System.out.println(s1);
        }

        List<Student> resultList = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        System.out.println(resultList);
        
        entityManager.getTransaction().begin();
        entityManager.remove(foundDepartment);
        entityManager.getTransaction().commit();

        System.out.println("---------------------");

//        try {
//            entityManager.getTransaction().begin();  
//            entityManager.persist(student);
//            entityManager.persist(unit);
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException exception){
//            System.out.println(exception.getClass());
//            // needs refactoring, may throw transaction inactive exception
//            entityManager.getTransaction().rollback();
//        }
//        Unit unitWithReadyID = new Unit();
//        unitWithReadyID.setName("Introduction to Algorithms");
//        unitWithReadyID.setNumberOfCredits(11);
//        unitWithReadyID.setSupervisor("Dimi Iracleous");
//        unitWithReadyID.setUnitType(UnitType.Lab);
//        unitWithReadyID.setId(1L);
//        
//        try {
//            entityManager.getTransaction().begin(); 
//            entityManager.merge(unitWithReadyID);
//            //entityManager.persist(unitWithReadyID); 
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException exception){
//            System.out.println(exception.getClass());
//            System.out.println(exception.getMessage());
//            // needs refactoring, may throw transaction inactive exception
//            entityManager.getTransaction().rollback();
//        }
//         
//        System.out.println("---------------------");  
//        
//        System.out.println(department.getId());
            // this should normally be under a service:
//        DepartmentRepositoryImpl departmentRepository = new DepartmentRepositoryImpl(entityManager);
//        departmentRepository.delete(department);
//        departmentRepository.save(department);
//        departmentRepository.read(0)
    }

}
