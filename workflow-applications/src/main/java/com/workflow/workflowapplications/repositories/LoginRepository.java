package com.workflow.workflowapplications.repositories;

import com.workflow.workflowapplications.models.Applicant;
import org.springframework.data.repository.CrudRepository;


public interface LoginRepository extends CrudRepository<Applicant, Long> {
    Applicant findByEmailAndPassword(String email, String password);
}
