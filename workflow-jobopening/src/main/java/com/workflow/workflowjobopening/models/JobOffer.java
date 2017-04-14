package com.workflow.workflowjobopening.models;

import com.workflow.workflowjobopening.modelsIn.JobOfferIn;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
public class JobOffer {

    @Id
    @GeneratedValue
    private Long id;
    private String codeBookId;
    private String title;
    private Date deadline;
    private  Boolean published;
    private int maxNumberApplicants;

    @ManyToOne
    @JoinColumn (name = "userId", referencedColumnName = "id")
    private User user;

    public JobOffer() {
    }


    public JobOffer(String title, Date deadline, Boolean published, int maxNumberApplicants, User user) {
        this.title = title;
        this.deadline = deadline;
        this.published = published;
        this.maxNumberApplicants = maxNumberApplicants;
        this.user = user;
    }

    public JobOffer(JobOfferIn jobOfferIn) {
        this.title = jobOfferIn.getTitle();
        this.deadline = jobOfferIn.getDeadline();
        this.published = jobOfferIn.getPublished();
        this.maxNumberApplicants = jobOfferIn.getMaxNumberApplicants();
       // this.user = jobOfferIn.getUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeBookId() {
        return codeBookId;
    }

    public void setCodeBookId(String codeBookId) {
        this.codeBookId = codeBookId;
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
