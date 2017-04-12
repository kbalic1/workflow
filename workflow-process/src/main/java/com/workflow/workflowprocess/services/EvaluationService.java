package com.workflow.workflowprocess.services;

import com.workflow.workflowprocess.models.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workflow.workflowprocess.repositories.EvaluationRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Tarik on 4/8/17.
 */
@Service
public class EvaluationService {

    @Autowired
    public void setEvaluationRepository(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Collection<Evaluation> getAllEvaluations() {
        List<Evaluation> evaluations = (List<Evaluation>) evaluationRepository.findAll();
        return evaluations;
    }

    public Evaluation get(Long id) {
        return evaluationRepository.findOne(id);
    }

    public Collection<Evaluation> getEvaluations(Long applicationId, Long stageId, int evaluation, String comment){
        return evaluationRepository.findByApplicationIdAndStageIdAndEvaluationAndComment(applicationId, stageId, evaluation, comment);
    }

    public Long add(Evaluation evaluation) {
        evaluationRepository.save(evaluation);
        return evaluation.getId();
    }

    public void delete(Long id) {
        evaluationRepository.delete(id);
    }

    public void update(Evaluation evaluation) {
        if (evaluationRepository.exists(evaluation.getId())) {
            evaluationRepository.save(evaluation);
        }
    }

}
