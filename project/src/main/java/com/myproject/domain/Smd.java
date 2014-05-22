package com.myproject.domain;

import javax.annotation.Generated;

/**
 * Smd is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Smd {

    private java.sql.Date dateAndTime;

    private String fullName;

    private String number;

    public java.sql.Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(java.sql.Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

