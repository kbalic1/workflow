package com.workflow.workflowprocess.repositories;

import com.workflow.workflowprocess.models.Evaluation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvaluationRepository extends CrudRepository<Evaluation, Long> {
    List<Evaluation> findByApplicationIdAndStageIdAndEvaluationAndComment(Long applicationId, Long stageId, int evaluation, String comment);
}

