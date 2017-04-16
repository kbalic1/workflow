package com.workflow.workflowapplications.models;

import com.workflow.workflowapplications.models.jobopening.JobOffer;

public class ApplicationExtended {
    private Long Id;
    private Applicant applicant;
    private Long jobOpeningId;
    private String status;
    private JobOffer jobOffer;

    public ApplicationExtended(Application application, JobOffer jobOffer) {
        this.Id = application.getId();
        this.applicant = application.getApplicant();
        this.jobOpeningId = application.getJobOpeningId();
        this.status = application.getStatus();
        this.jobOffer = jobOffer;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

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
