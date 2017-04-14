package com.workflow.workflowjobopening.services;

import com.workflow.workflowjobopening.models.JobOffer;
import com.workflow.workflowjobopening.modelsIn.JobOfferIn;
import com.workflow.workflowjobopening.modelsOut.JobOfferOut;
import com.workflow.workflowjobopening.repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public List<JobOfferOut> exportAsList(){
        return jobOfferRepository.findAll().stream().map(p -> new JobOfferOut(p)).collect(Collectors.toList());
    }

    public Boolean importFromInput(JobOfferIn jobOfferIn){

        final JobOffer jobOffer = new JobOffer(jobOfferIn);
        jobOfferRepository.save(jobOffer);
        jobOfferRepository.flush();
        return true;
    }

    public void removeById (Long jobOfferId){
        jobOfferRepository.delete(jobOfferId);
    }
}
