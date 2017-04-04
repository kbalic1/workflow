package com.workflow.workflowapplications.controllers;

import com.workflow.workflowapplications.models.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.workflow.workflowapplications.services.ApplicantService;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api/applicant")
public class ApplicantController {


    @Autowired
    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    private ApplicantService applicantService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Applicant getApplicant(@PathVariable("id") Long id) {
        return applicantService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Applicant> getApplicants(@RequestParam("email") String email,
                                               @RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName) {
        return applicantService.getApplicants(email, firstName, lastName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addApplicant(@RequestBody Applicant applicant) {
        Long applicantId = applicantService.add(applicant);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(applicantId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteApplicant(@PathVariable("id") Long id) {
        applicantService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateApplicant(@PathVariable("id") Long id, @RequestBody Applicant applicant) {
        applicantService.update(applicant);
        return ResponseEntity.ok().build();
    }
}
