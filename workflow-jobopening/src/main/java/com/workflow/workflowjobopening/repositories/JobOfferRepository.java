package com.workflow.workflowjobopening.repositories;

import com.workflow.workflowjobopening.models.JobOffer;
import com.workflow.workflowjobopening.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by tile on 4/8/2017.
 */
public interface JobOfferRepository extends JpaRepository<JobOffer,Long>,JpaSpecificationExecutor<JobOffer> {

    List<JobOffer> findAllByPublished (Boolean published);
    void removeByUser (User user);
    void removeById (Long Id);
}
