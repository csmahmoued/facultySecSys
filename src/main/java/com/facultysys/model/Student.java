package com.facultysys.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studid;
    private int studpid;
    private int studNationalId;
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

    public Student(){}
    public  Student(int studid){
        this.studid=studid;
    }


    public int getStudid() {
        return studid;
    }

    public void setStudid(int studid) {
        this.studid = studid;
    }

    public int getStudpid() {
        return studpid;
    }

    public void setStudpid(int studpid) {
        this.studpid = studpid;
    }

    public int getStudNationalId() {
        return studNationalId;
    }

    public void setStudNationalId(int studNationalId) {
        this.studNationalId = studNationalId;
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

