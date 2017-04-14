package com.workflow.workflowjobopening.modelsOut;

import com.workflow.workflowjobopening.models.Stage;

public class StageOut {

    private Long Id;

    private String name;

    public StageOut() {
    }

    public StageOut(String name) {
        this.name = name;
    }

    public StageOut(Stage stage) {
        this.Id = stage.getId();
        this.name = stage.getName();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
