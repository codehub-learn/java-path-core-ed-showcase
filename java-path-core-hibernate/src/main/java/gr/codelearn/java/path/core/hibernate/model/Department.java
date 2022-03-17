/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author mcjohn1
 */
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Column(name = "myUniversityName", nullable = false, length = 150)
    private String universityName;
    
    @OneToMany(mappedBy = "department", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Student> students;
    
    @OneToMany(mappedBy = "department", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Unit> units;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    private Department(Builder builder) {
        id = builder.id;
        name = builder.name;
        universityName = builder.universityName;
        students = builder.students;
        units = builder.units;
    }

    public Department() {
    }
    
    
    
    public static final class Builder {
        private Long id;
        private String name;
        private String universityName;
        private List<Student> students;
        private List<Unit> units;

        public Builder() {
        }

        public Builder setId(Long val) {
            id = val;
            return this;
        }

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Builder setUniversityName(String val) {
            universityName = val;
            return this;
        }

        public Builder setStudents(List<Student> val) {
            students = val;
            return this;
        }

        public Builder setUnits(List<Unit> val) {
            units = val;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
    
    
    
}
