package com.workflow.workflowapplications.repositories;

import com.workflow.workflowapplications.models.Applicant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
    List<Applicant> findByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);
    List<Applicant> findByEmail(String email);
}
