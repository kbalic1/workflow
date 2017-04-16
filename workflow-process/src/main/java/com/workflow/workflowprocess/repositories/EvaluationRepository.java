package com.workflow.workflowprocess.repositories;

import com.workflow.workflowprocess.models.Evaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends CrudRepository<Evaluation, Long> {
    List<Evaluation> findByApplicationIdAndStageIdAndEvaluationAndComment(Long applicationId, Long stageId, int evaluation, String comment);

    @Query("SELECT new com.workflow.workflowprocess.models.Evaluation(e) "
            + "FROM com.workflow.workflowprocess.models.Evaluation e "
            + "WHERE  e.stageId = :stageId ")
    List<Evaluation> getAllWithStageId(@Param("stageId") Long stageId);

}

