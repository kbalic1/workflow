package com.workflow.workflowapplications.restclients;

import com.workflow.workflowapplications.models.jobOpenings.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class JobOpeningClient {

    private RestTemplate restTemplate;

    public JobOpeningClient() {
        restTemplate = new RestTemplate();
    }

    public JobOffer getJobOpening(Long jobOpeningId) {
        String uri = "http://jobopening/" + jobOpeningId;
        JobOffer jobOffer = restTemplate.getForObject(uri, JobOffer.class);
        return jobOffer;
    }
}
