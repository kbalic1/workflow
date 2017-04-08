package com.workflow.workflowjobopening.repositories;


import com.workflow.workflowjobopening.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by tile on 4/8/2017.
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
}
