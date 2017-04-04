package com.workflow.workflowapplications.services;

import com.workflow.workflowapplications.models.Applicant;
import com.workflow.workflowapplications.models.Application;
import com.workflow.workflowapplications.repositories.ApplicantRepository;
import com.workflow.workflowapplications.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private ApplicantRepository applicantRepository;

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Autowired
    public void setApplicantRepository(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Collection<Application> getAllApplications() {
        List<Application> applications = (List<Application>) applicationRepository.findAll();
        return applications;
    }

    public Application get(Long id) {
        return applicationRepository.findOne(id);
    }

    public Collection<Application> getApplications(Applicant applicant, Long jobOpeningId, String status) {
        List<Application> applications = applicationRepository
                .findByApplicantAndJobOpeningIdAndStatus(applicant, jobOpeningId, status);

        return applications;
    }

    public Long add(Application application) {
        Applicant applicant = applicantRepository.findOne(application.getApplicant().getId());
        application.setApplicant(applicant);

        applicationRepository.save(application);
        return application.getId();
    }

    public void delete(Long id) {
        applicationRepository.delete(id);
    }

    public void update(Application application) {
        if (applicationRepository.exists(application.getId())) {
            applicationRepository.save(application);
        }
    }
}
