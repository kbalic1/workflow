package com.workflow.workflowjobopening.modelsIn;

import com.workflow.workflowjobopening.models.JobOffer;
import com.workflow.workflowjobopening.models.User;

import java.util.Date;

/**
 * Created by tile on 4/8/2017.
 */

public class JobOfferIn {


    private String title;
    private Date deadline;
    private  Boolean published;
    private int maxNumberApplicants;

    private User user;

    public JobOfferIn() {
    }


    public JobOfferIn(String title, Date deadline, Boolean published, int maxNumberApplicants, User user) {
        this.title = title;
        this.deadline = deadline;
        this.published = published;
        this.maxNumberApplicants = maxNumberApplicants;
        this.user = user;
    }

    public JobOfferIn(JobOffer jobOffer) {
        this.title = jobOffer.getTitle();
        this.deadline = jobOffer.getDeadline();
        this.published = jobOffer.getPublished();
        this.maxNumberApplicants = jobOffer.getMaxNumberApplicants();
        this.user = jobOffer.getUser();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public int getMaxNumberApplicants() {
        return maxNumberApplicants;
    }

    public void setMaxNumberApplicants(int maxNumberApplicants) {
        this.maxNumberApplicants = maxNumberApplicants;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
