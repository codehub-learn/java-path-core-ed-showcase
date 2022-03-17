/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.java.path.core.hibernate.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    
    @Enumerated(value = EnumType.ORDINAL)
    private UnitType unitType;
    
    private int numberOfCredits;
    
    private String supervisor;
    
    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "unit")
    private List<StudentUnit> studentUnits;

    public Unit() {
    }

    

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

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<StudentUnit> getStudentUnits() {
        return studentUnits;
    }

    public void setStudentUnits(List<StudentUnit> studentUnits) {
        this.studentUnits = studentUnits;
    }

    public Unit(String name, UnitType unitType, int numberOfCredits, String supervisor, Department department, List<StudentUnit> studentUnits) {
        this.name = name;
        this.unitType = unitType;
        this.numberOfCredits = numberOfCredits;
        this.supervisor = supervisor;
        this.department = department;
        this.studentUnits = studentUnits;
    }

    public Unit(String name, UnitType unitType, int numberOfCredits, String supervisor, Department department) {
        this.name = name;
        this.unitType = unitType;
        this.numberOfCredits = numberOfCredits;
        this.supervisor = supervisor;
        this.department = department;
    }
    
}
