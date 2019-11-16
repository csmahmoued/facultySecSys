package com.facultysys.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


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
