package com.facultysys.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class CourseDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private double degree;

    @ManyToOne
    @JoinColumn(name="deptId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @ManyToOne
    @JoinColumn(name="studId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
