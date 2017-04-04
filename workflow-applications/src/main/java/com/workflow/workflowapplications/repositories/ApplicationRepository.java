package com.workflow.workflowapplications.repositories;

import com.workflow.workflowapplications.models.Applicant;
import com.workflow.workflowapplications.models.Application;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> findByApplicantAndJobOpeningIdAndStatus(Applicant applicant, Long jobOpeningId, String status);
}
