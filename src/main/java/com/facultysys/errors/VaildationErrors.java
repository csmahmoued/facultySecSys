package com.facultysys.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VaildationErrors {

    private List<String> errors;
    private String uri;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yy hh:mm:ss")
    private Date timestape;

  public  VaildationErrors(){
        this.timestape=new Date();
        this.errors=new ArrayList<>();
    }
    public void addError(String error){
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimestape() {
        return timestape;
    }

    public void setTimestape(Date timestape) {
        this.timestape = timestape;
    }
}
