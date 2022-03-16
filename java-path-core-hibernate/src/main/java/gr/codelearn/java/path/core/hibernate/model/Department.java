/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @Column(name = "myDescription", nullable = false)
    private String description;
    
    @OneToMany(mappedBy = "department")
    private List<Student> students;
    
    @OneToMany(mappedBy = "department")
    private List<Unit> units;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
