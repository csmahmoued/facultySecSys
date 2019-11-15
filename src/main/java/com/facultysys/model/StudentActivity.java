package com.facultysys.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StudentActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String activityType;
    @Lob
    private String  activityDesc;

    @Temporal(TemporalType.DATE)
    private Date acivityDate;

    public StudentActivity(){
        this.acivityDate=new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Date getAcivityDate() {
        return acivityDate;
    }

    public void setAcivityDate(Date acivityDate) {
        this.acivityDate = acivityDate;
    }
}
