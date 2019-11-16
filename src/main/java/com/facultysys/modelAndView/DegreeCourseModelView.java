package com.facultysys.modelAndView;

public class DegreeCourseModelView {


    private  int id;
    private double degree;
    private int studpid;
    private int courseid;
    private String coursename;
    private String mdegree;

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

    public int getStudpid() {
        return studpid;
    }

    public void setStudpid(int studpid) {
        this.studpid = studpid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
}
