package com.facultysys.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int deptId;
    private  String deptName;
    @Lob
    private String deptVission;
    @Lob
    private  String deptMission;
    @Lob
    private String deptActivities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> student;

    public Department(){}

    public Department(String deptName){
        this.deptName=deptName;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptVission() {
        return deptVission;
    }

    public void setDeptVission(String deptVission) {
        this.deptVission = deptVission;
    }

    public String getDeptMission() {
        return deptMission;
    }

    public void setDeptMission(String deptMission) {
        this.deptMission = deptMission;
    }

    public String getDeptActivities() {
        return deptActivities;
    }

    public void setDeptActivities(String deptActivities) {
        this.deptActivities = deptActivities;
    }
}
