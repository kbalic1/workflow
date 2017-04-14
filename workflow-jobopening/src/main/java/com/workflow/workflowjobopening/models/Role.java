package com.workflow.workflowjobopening.models;

import com.workflow.workflowjobopening.modelsIn.RoleIn;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stageId", referencedColumnName = "id")
    private Stage stage;

    @ManyToOne
    @JoinColumn (name = "jobOfferId", referencedColumnName = "id")
    private JobOffer jobOffer;

    @ManyToOne
    @JoinColumn (name = "userId", referencedColumnName = "id")
    private User user;

    public Role() {
    }

    public Role(Stage stage, JobOffer jobOffer, User user) {
        this.stage = stage;
        this.jobOffer = jobOffer;
        this.user = user;
    }

    public Role(RoleIn roleIn) {
        this.stage.setId(roleIn.getStage());
        this.jobOffer.setId(roleIn.getJobOffer());
        this.user.setId(roleIn.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
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
