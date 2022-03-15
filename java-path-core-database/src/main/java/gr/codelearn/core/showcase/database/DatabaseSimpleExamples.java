package gr.codelearn.core.showcase.database;

import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;
import gr.codelearn.core.showcase.database.repository.DepartmentRepository;
import gr.codelearn.core.showcase.database.repository.DepartmentRepositoryImpl;
import gr.codelearn.core.showcase.database.repository.StudentRepository;
import gr.codelearn.core.showcase.database.repository.StudentRepositoryImpl;
import java.sql.Connection;

public class DatabaseSimpleExamples {

    public static void main(String[] args) {
        Connection connection = JDBCConnection.getConnection();
        DepartmentRepository dpr = new DepartmentRepositoryImpl(connection);
        dpr.createTable();
        dpr.insert(new Department("Computer Science", "MIT"));
        dpr.insert(new Department("Economics", "OPA"));
        dpr.selectAll().forEach(System.out::println);

        StudentRepository str = new StudentRepositoryImpl(connection);
        str.createTable();
        str.insert(new Student("Ironman","ironman@avengers.com",50,1));
        str.insert(new Student("Hulk","hulk@avengers.com",150,1));
        str.selectAll().forEach(System.out::println);
        
        System.out.println("INNER JOIN EXAMPLE");
        dpr.selectStudentWithDepartmentId(1).forEach(System.out::println);

    }

}
