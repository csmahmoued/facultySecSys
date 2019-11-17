package com.facultysys.modelAndView;

import javax.validation.constraints.NotNull;

public class CourseModelView {

    private  String courseId;
    private  String courseName;
    private  String courseLectNo;
    private  String courseDesc;
    private  String courseTerm;
    private  String courseYear;
    @NotNull(message = "department id can not be null")
    private String  deptId;
    private String deptName;
    @NotNull(message = "staff id can not be null")
    private String  staffId;
    private String  staffName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
