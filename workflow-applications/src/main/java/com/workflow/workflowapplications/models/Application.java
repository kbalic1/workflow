package com.workflow.workflowapplications.models;

import com.workflow.workflowapplications.models.jobOpenings.JobOffer;

import javax.persistence.*;


@Entity
public class Application {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;
    private Long jobOpeningId;
    private String status;

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    private JobOffer jobOffer;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Long getJobOpeningId() {
        return jobOpeningId;
    }

    public void setJobOpeningId(Long jobOpeningId) {
        this.jobOpeningId = jobOpeningId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
