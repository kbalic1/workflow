package com.workflow.workflowjobopening.repositories;

import com.workflow.workflowjobopening.models.JobOffer;
import com.workflow.workflowjobopening.models.User;
import com.workflow.workflowjobopening.modelsOut.JobOfferOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by tile on 4/8/2017.
 */
public interface JobOfferRepository extends JpaRepository<JobOffer,Long>,JpaSpecificationExecutor<JobOffer> {

    List<JobOffer> findAllByPublished (Boolean published);
    void removeByUser (User user);
    void removeById (Long Id);

    // @formatter:off
    @Query("SELECT new com.workflow.workflowjobopening.modelsOut.JobOfferOut(jo) "
            + "FROM com.workflow.workflowjobopening.models.JobOffer jo "
            + "WHERE  jo.deadline <= :date ")
    List<JobOfferOut> getAllBeforeDeadlineDate(@Param("date") Date date);
    // @formatter:on
}
