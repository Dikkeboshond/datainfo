package com.myproject.domain;

import javax.annotation.Generated;

/**
 * Skill is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Skill {

    private String description;

    private Integer skillId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

}

