package com.workflow.workflowprocess.controllers;

import com.workflow.workflowprocess.models.Evaluation;
import com.workflow.workflowprocess.models.User;
import com.workflow.workflowprocess.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api/evaluation")
public class EvaluationController {

    @Autowired
    public void setEvaluationService(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    private EvaluationService evaluationService;

    @RequestMapping(value = "/{id", method = RequestMethod.GET)
    public Evaluation getEvaluation(@PathVariable("id") long id) {
        return evaluationService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Evaluation> getEvaluations(@RequestParam("applicationId") Long applicationId,
                                                 @Requestparam("stageId") Long stageId,
                                                 @RequestParam("evaluation") int evaluation,
                                                 @RequestParam("comment") String comment) {
        return evaluationService.getEvaluations(applicationId, stageId, evaluation, comment);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addEvaluation(@RequestBody Evaluation evaluation) {
        Long evaluationId = evaluationService.add(evaluation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(applicationId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEvaluation(@PathVariable("id") Long id) {
        evaluationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEvaluation(@PathVariable("id") Long id, @RequestBody Evaluation evaluation) {
        evaluationService.update(evaluation);
        return ResponseEntity.ok().build();
    }



}
