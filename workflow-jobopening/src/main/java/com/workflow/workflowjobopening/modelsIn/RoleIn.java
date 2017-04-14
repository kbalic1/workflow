package com.workflow.workflowjobopening.modelsIn;

public class RoleIn {

    private Long stage;

    private Long jobOffer;

    private Long user;

    public RoleIn() {
    }

    public RoleIn(Long stage, Long jobOffer, Long user) {
        this.stage = stage;
        this.jobOffer = jobOffer;
        this.user = user;
    }

    public Long getStage() {
        return stage;
    }

    public void setStage(Long stage) {
        this.stage = stage;
    }

    public Long getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(Long jobOffer) {
        this.jobOffer = jobOffer;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
