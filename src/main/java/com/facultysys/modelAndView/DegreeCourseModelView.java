package com.facultysys.modelAndView;

public class DegreeCourseModelView {


    private  int id;
    private double degree;
    private String studpid;
    private int courseid;
    private String coursename;
    private String  studName;
    private String mdegree;

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getMdegree() {
        return mdegree;
    }

    public void setMdegree(String mdegree) {
        this.mdegree = mdegree;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

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

    public String getStudpid() {
        return studpid;
    }

    public void setStudpid(String studpid) {
        this.studpid = studpid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
}
