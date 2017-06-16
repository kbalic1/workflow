package com.workflow.workflowprocess.repositories;

import com.workflow.workflowprocess.models.User;
import org.springframework.data.repository.CrudRepository;


public interface LoginRepository extends CrudRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
