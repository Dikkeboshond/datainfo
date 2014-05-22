package com.myproject.domain;

import javax.annotation.Generated;

/**
 * Node is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Node {

    private Boolean commentsEnabled;

    private java.sql.Date dateAndTime;

    private Integer nid;

    private String number;

    private String title;

    public Boolean getCommentsEnabled() {
        return commentsEnabled;
    }

    public void setCommentsEnabled(Boolean commentsEnabled) {
        this.commentsEnabled = commentsEnabled;
    }

    public java.sql.Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(java.sql.Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

