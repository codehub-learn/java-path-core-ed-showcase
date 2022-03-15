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

public class StudentRepositoryImpl implements StudentRepository{
    private Connection connection;

    public StudentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
        private String name;
    private String email;
    private Integer age;
    private Integer departmentId;

    @Override
    public void createTable() {
                String sql="""
                   create table if not exists student (
                   studentId int not null AUTO_INCREMENT,
                   name VARCHAR(20), 
                   email VARCHAR(20),
                   age int,
                   departmentId int not null, 
                   primary key (studentId),
                   FOREIGN KEY (departmentId) REFERENCES department(departmentId) )
                   """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Student student) {
        String sql="""
                   insert into student values 
                   (NULL,?,?,?,?)
                   """;
        try(PreparedStatement prepareStatement = connection.prepareStatement(sql)){
            prepareStatement.setString(1, student.getName());
            prepareStatement.setString(2, student.getEmail());
            prepareStatement.setInt(3, student.getAge());
            prepareStatement.setInt(4, student.getDepartmentId());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        String sql="""
                   select * from student
                   """;
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setDepartmentId(resultSet.getInt("departmentId"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    } 
}
