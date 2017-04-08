package com.workflow.workflowprocess.repositories;


import com.workflow.workflowprocess.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
