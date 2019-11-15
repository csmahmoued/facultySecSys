package com.facultysys.model;

import javax.persistence.*;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String from;
    private  String to;

    @Lob
    private  String eventDec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEventDec() {
        return eventDec;
    }

    public void setEventDec(String eventDec) {
        this.eventDec = eventDec;
    }
}
