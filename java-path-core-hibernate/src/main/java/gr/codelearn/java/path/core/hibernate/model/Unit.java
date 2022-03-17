/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author mcjohn1
 */
@Entity
public class Unit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private UnitType unitType;
    
    private int numberOfCredits;
    
    private String supervisor;
    
    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "unit")
    private List<StudentUnit> studentUnits;
    
}
