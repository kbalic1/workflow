package com.workflow.workflowapplications.models;

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
