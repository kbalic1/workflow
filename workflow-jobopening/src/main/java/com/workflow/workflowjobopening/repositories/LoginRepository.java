package com.workflow.workflowjobopening.repositories;

import com.workflow.workflowjobopening.models.User;
import org.springframework.data.repository.CrudRepository;


public interface LoginRepository extends CrudRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
