package com.facultysys.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studId;
    private  String studName;
    private String studCity;
    private String studState;
    private  String studEmail;
    private  String studPhone;
    private  String studbday;
    @Transient
    private int age;

    @ManyToOne
    @JoinColumn(name="deptId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudCity() {
        return studCity;
    }

    public void setStudCity(String studCity) {
        this.studCity = studCity;
    }

    public String getStudState() {
        return studState;
    }

    public void setStudState(String studState) {
        this.studState = studState;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getStudPhone() {
        return studPhone;
    }

    public void setStudPhone(String studPhone) {
        this.studPhone = studPhone;
    }

    public String getStudbday() {
        return studbday;
    }

    public void setStudbday(String studbday) {
        this.studbday = studbday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

