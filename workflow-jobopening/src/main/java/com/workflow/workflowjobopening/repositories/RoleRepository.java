package com.workflow.workflowjobopening.repositories;

import com.workflow.workflowjobopening.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by tile on 4/8/2017.
 */
public interface RoleRepository extends JpaRepository<Role,Long>,JpaSpecificationExecutor<Role> {
}
