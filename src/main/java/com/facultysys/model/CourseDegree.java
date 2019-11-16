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
    @JoinColumn(name="courseId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Courses courses;

    @ManyToOne
    @JoinColumn(name="studpid")
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

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
