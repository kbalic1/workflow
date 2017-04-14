package com.workflow.workflowjobopening.modelsOut;

import com.workflow.workflowjobopening.models.JobOffer;
import com.workflow.workflowjobopening.models.Role;
import com.workflow.workflowjobopening.models.Stage;
import com.workflow.workflowjobopening.models.User;


public class RoleOut {

    private Long Id;

    private Stage stage;

    private JobOffer jobOffer;

    private User user;

    public RoleOut() {
    }

    public RoleOut(Stage stage, JobOffer jobOffer, User user) {
        this.stage = stage;
        this.jobOffer = jobOffer;
        this.user = user;
    }

    public RoleOut(Role role) {
        this.Id = role.getId();
        this.stage = role.getStage();
        this.jobOffer = role.getJobOffer();
        this.user = role.getUser();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
