package com.facultysys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FacultyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Lob
    private String mission;
    @Lob
    private  String vission;
    @Lob
    private  String goals;
    @Lob
    private  String breif;
    @Lob
    private String history;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVission() {
        return vission;
    }

    public void setVission(String vission) {
        this.vission = vission;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getBreif() {
        return breif;
    }

    public void setBreif(String breif) {
        this.breif = breif;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
