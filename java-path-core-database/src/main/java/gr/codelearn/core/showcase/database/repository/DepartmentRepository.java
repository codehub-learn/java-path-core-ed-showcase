package gr.codelearn.core.showcase.database.repository;

import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;
import java.util.List;

public interface DepartmentRepository {
    void createTable();
    void insert(Department department);
    List<Department> selectAll();
    List<Student> selectStudentWithDepartmentId(Integer id);
}
