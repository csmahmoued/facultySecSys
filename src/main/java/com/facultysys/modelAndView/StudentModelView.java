package com.facultysys.modelAndView;

import javax.validation.constraints.NotNull;

public class StudentModelView {

    private String studid;
    @NotNull(message = "student pid cant not be null")
    private String studpid;
    @NotNull
    private String studNationalId;
    private String studName;
    private String studCity;
    private String studState;
    private  String studEmail;
    private  String studPhone;
    private  String studbday;
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @NotNull(message = "department id can not be null ")
    private String deptId;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getStudid() {
        return studid;
    }

    public void setStudid(String studid) {
        this.studid = studid;
    }

    public String getStudpid() {
        return studpid;
    }

    public void setStudpid(String studpid) {
        this.studpid = studpid;
    }

    public String getStudNationalId() {
        return studNationalId;
    }

    public void setStudNationalId(String studNationalId) {
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
}
