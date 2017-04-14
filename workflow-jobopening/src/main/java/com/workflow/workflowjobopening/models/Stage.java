package com.workflow.workflowjobopening.models;

import com.workflow.workflowjobopening.modelsIn.StageIn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tile on 4/8/2017.
 */
@Entity
public class Stage {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Stage() {
    }

    public Stage(String name) {
        this.name = name;
    }

    public Stage(StageIn stageIn) {
        this.name = stageIn.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
