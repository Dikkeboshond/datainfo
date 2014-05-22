package com.myproject.domain;

import javax.annotation.Generated;

/**
 * Comment is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Comment {

    private byte[] body;

    private java.sql.Date dateAndTime;

    private Integer downvotes;

    private Integer nid;

    private String number;

    private Integer upvotes;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public java.sql.Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(java.sql.Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
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

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

}

