
package gr.codelearn.core.showcase.database.repository;

import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;
import java.util.List;

public interface StudentRepository {
    void createTable();
    void insert(Student student);
    List<Student> selectAll();
}
