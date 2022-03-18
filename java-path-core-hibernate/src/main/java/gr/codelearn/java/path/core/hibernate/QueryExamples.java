/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate;

import gr.codelearn.java.path.core.hibernate.model.Student;
import gr.codelearn.java.path.core.hibernate.model.Unit;
import gr.codelearn.java.path.core.hibernate.model.UnitType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mcjohn1
 */
public class QueryExamples {

    public static void main(String[] args) {
//Initialize entity manager
        //Tables are created
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UniversityPU");
        EntityManager entityManager = emf.createEntityManager();

        findAll(entityManager);

        findByDepartmentId(entityManager);

        findUnitsOfStudent(entityManager);

        namedQuery(entityManager);

        positionalQuery(entityManager);

        max(entityManager);

        update(entityManager);

        delete(entityManager);
    }

    private static void findAll(EntityManager entityManager) {
        List<Student> resultList = entityManager.createQuery("FROM Student").getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }
    }

    private static void findByDepartmentId(EntityManager entityManager) {
        //@formatter:off
        List<Student> studentList = entityManager
                .createQuery("SELECT s FROM Student s WHERE s.department.id = :id", Student.class)
                .setParameter("id", 1L)
                .getResultList();
        //@formatter:on
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void findUnitsOfStudent(EntityManager entityManager) {
        //@formatter:off
        Student student = new Student();
        student.setId(4L);
        //Query the units of the student
        List<Unit> unitList
                = entityManager
                        .createQuery(
                                "SELECT u "
                                + "FROM Unit u "
                                + "INNER JOIN StudentUnit su "
                                + "ON u = su.unit "
                                + "WHERE su.student =: student",
                                Unit.class)
                        .setParameter("student", student)
                        .getResultList();
        //@formatter:on
        for (Unit unit : unitList) {
            System.out.println(unit);
        }
    }

    private static void namedQuery(EntityManager entityManager) {
        // Parameter can either be a list or a single unit type (check named query)
        List<UnitType> unitTypeList = List.of(UnitType.Lab, UnitType.Lecture);
        //@formatter:off
        List<Unit> unitList = entityManager
                .createNamedQuery("findAllUnitsWithType")
                .setParameter("unitType", unitTypeList)
                .getResultList();
        //@formatter:on
        for (Unit unit : unitList) {
            System.out.println(unit);
        }
    }

    private static void positionalQuery(EntityManager entityManager) {
        //@formatter:off
        List<Student> studentList = entityManager
                .createQuery(
                        "SELECT s "
                        + "FROM Student s "
                        + "WHERE s.name "
                        + "LIKE ?1"
                )
                .setParameter(1, "Tom%")
                .getResultList();
        //@formatter:on
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void max(EntityManager entityManager) {
        //@formatter:off
        List<Number> max = entityManager
                .createQuery(
                        "SELECT MAX(u.numberOfCredits) "
                        + "FROM Unit u "
                        + "WHERE u.unitType = :unitType"
                )
                .setParameter("unitType", UnitType.Online)
                .getResultList();
        //@formatter:on
        System.out.println(max);

    }

    private static void update(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        //@formatter:off
        entityManager.createQuery(
                "UPDATE Unit u "
                + "SET u.unitType = :unitType "
                + "WHERE u.numberOfCredits > :numberOfCredits"
        )
                .setParameter("unitType", UnitType.Lecture)
                .setParameter("numberOfCredits", 90)
                .executeUpdate();
        //@formatter:on
        entityManager.getTransaction().commit();
    }

    private static void delete(EntityManager entityManager) {
        Student student = new Student();
        student.setId(3L);
        Unit unit = new Unit();
        unit.setId(1L);

        entityManager.getTransaction().begin();
        //@formatter:off
        entityManager.createQuery(
                "DELETE FROM StudentUnit su "
                + "WHERE su.student = :student "
                + "AND su.unit = :unit"
        )
                .setParameter("student", student)
                .setParameter("unit", unit)
                .executeUpdate();
        //@formatter:on
        entityManager.getTransaction().commit();
    }
}
