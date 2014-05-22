package com.myproject.domain;

import javax.annotation.Generated;

/**
 * Idea is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Idea {

    private Boolean archived;

    private byte[] description;

    private Integer downvotes;

    private Integer nid;

    private byte[] picture;

    private Integer upvotes;

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

}

