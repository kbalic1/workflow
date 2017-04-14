package com.workflow.workflowjobopening.services;

import com.workflow.workflowjobopening.models.Stage;
import com.workflow.workflowjobopening.modelsIn.StageIn;
import com.workflow.workflowjobopening.modelsOut.StageOut;
import com.workflow.workflowjobopening.repositories.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    public List<StageOut> exportAsList(){
        return stageRepository.findAll().stream().map(p -> new StageOut(p)).collect(Collectors.toList());
    }

    public Boolean importFromInput(StageIn stageIn){

        final Stage jobOffer = new Stage(stageIn);
        stageRepository.save(jobOffer);
        stageRepository.flush();
        return true;
    }

    public void removeById (Long stageId){
        stageRepository.delete(stageId);
    }
}
