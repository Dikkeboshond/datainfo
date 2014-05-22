package com.myproject.domain;

import javax.annotation.Generated;

/**
 * Role is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Role {

    private String description;

    private Integer rid;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}

