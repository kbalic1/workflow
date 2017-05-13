package com.workflow.workflowapplications.services;

import com.workflow.workflowapplications.models.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workflow.workflowapplications.repositories.ApplicantRepository;

import java.util.Collection;
import java.util.List;

@Service
public class ApplicantService {

    private ApplicantRepository applicantRepository;

    @Autowired
    public void setApplicantRepository(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Collection<Applicant> getAllApplicants() {
        List<Applicant> applicants = (List<Applicant>) applicantRepository.findAll();
        return applicants;
    }

    public Applicant get(Long id) {
        return applicantRepository.findOne(id);
    }


    public Collection<Applicant> getApplicants(String email, String firstName, String lastName) {
        return applicantRepository.findByEmailAndFirstNameAndLastName(email, firstName, lastName);
    }

    public Applicant getApplicantByEmail(String email) {
        return applicantRepository.findByEmail(email);
    }

    public Long add(Applicant applicant) {
        applicantRepository.save(applicant);
        return applicant.getId();
    }

    public void delete(Long id) {
        applicantRepository.delete(id);
    }

    public void update(Applicant applicant) {
        if (applicantRepository.exists(applicant.getId())) {
            applicantRepository.save(applicant);
        }
    }
}
