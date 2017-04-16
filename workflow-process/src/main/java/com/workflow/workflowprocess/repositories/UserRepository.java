package com.workflow.workflowprocess.repositories;

import com.workflow.workflowprocess.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

    @Query("SELECT new com.workflow.workflowprocess.models.User(u) "
            + "FROM com.workflow.workflowprocess.models.User u "
            + "WHERE  u.firstName = :firstName ")
    List<User> getAllWithFirstName(@Param("firstName") String firstName);

}
