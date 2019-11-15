package com.facultysys.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int courseId;
    private  String courseName;
    private  String courseLectNo;
    private  String courseDesc;
    private  String courseTerm;
    private  String courseYear;
    @ManyToOne
    @JoinColumn(name="deptId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @ManyToOne
    @JoinColumn(name="staffId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Staff staff;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLectNo() {
        return courseLectNo;
    }

    public void setCourseLectNo(String courseLectNo) {
        this.courseLectNo = courseLectNo;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
