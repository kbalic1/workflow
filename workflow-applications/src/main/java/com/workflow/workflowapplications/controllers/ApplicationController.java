package com.workflow.workflowapplications.controllers;

import com.workflow.workflowapplications.models.Applicant;
import com.workflow.workflowapplications.models.Application;
import com.workflow.workflowapplications.models.ApplicationExtended;
import com.workflow.workflowapplications.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api/application")
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Application getApplication(@PathVariable("id") Long id) {
        return applicationService.get(id);
    }

    @RequestMapping(value = "/{id}/withOpening", method = RequestMethod.GET)
    public ApplicationExtended getApplicationWithOpening(@PathVariable("id") Long id) {
        return applicationService.getWithOpening(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Application> getApplications(@RequestParam("applicant") Applicant applicant,
                                                 @RequestParam("jobOpeningId") Long jobOpeningId,
                                                 @RequestParam("status") String status) {
        return applicationService.getApplications(applicant, jobOpeningId, status);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addApplication(@RequestBody Application application) {
        Long applicationId = applicationService.add(application);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(applicationId)
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
