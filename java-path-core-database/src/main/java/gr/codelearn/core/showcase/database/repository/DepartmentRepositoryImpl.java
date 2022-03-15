package gr.codelearn.core.showcase.database.repository;

import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private Connection connection;

    public DepartmentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
        String sql = """
                   create table if not exists department (
                   departmentId int not null AUTO_INCREMENT,
                   name VARCHAR(20), 
                   uniName VARCHAR(20), 
                   primary key (departmentId) )
                   """;
        try ( Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Department department) {
        String sql = """
                   insert into department (name,uniName) values  
                   (?,?)
                   """;
        try ( PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, department.getName());
            prepareStatement.setString(2, department.getUniName());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Department> selectAll() {
        List<Department> departments = new ArrayList<>();
        String sql = """
                   select * from department
                   """;
        try ( Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department department = new Department();
                department.setName(resultSet.getString("name"));
                department.setUniName(resultSet.getString("uniName"));
                departments.add(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }

    @Override
    public List<Student> selectStudentWithDepartmentId(Integer id) {
        List<Student> students = new ArrayList<>();
        String sql = """
                   select student.name, student.email from department 
                     inner join student on (department.departmentId = student.departmentId) 
                     where department.departmentId = ?
                   """;
        try ( PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

}
