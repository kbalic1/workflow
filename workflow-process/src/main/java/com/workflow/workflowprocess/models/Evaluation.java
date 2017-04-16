package com.workflow.workflowprocess.models;

import javax.persistence.*;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private Long applicationId;
    private Long stageId;
    private int evaluation;
    private String comment;

    protected Evaluation() {}

    public Evaluation(Evaluation e){
        this.user = e.getUser();
        this.applicationId = e.getApplicationId();
        this.stageId = e.getStageId();
        this.evaluation = e.getEvaluation();
        this.comment = e.getComment();
    }

    public Evaluation(User user, Long applicationId, Long stageId, int evaluation, String comment) {

        this.user = user;
        this.applicationId = applicationId;
        this.stageId = stageId;
        this.evaluation = evaluation;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("%d %s", evaluation, comment);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
