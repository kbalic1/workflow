package com.workflow.workflowprocess.repositories;

import com.workflow.workflowprocess.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

}
