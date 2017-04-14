package com.workflow.workflowjobopening.controllers;

import com.workflow.workflowjobopening.modelsIn.JobOfferIn;
import com.workflow.workflowjobopening.modelsOut.JobOfferOut;
import com.workflow.workflowjobopening.services.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/joboffer", produces = "application/json")
public class JobOfferController {

    @Autowired
    private JobOfferService service;

    @RequestMapping(method = RequestMethod.POST, consumes ="application/json")
    @ResponseBody
    public Boolean importJobOffer(@RequestBody JobOfferIn input) {
        return service.importFromInput(input);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<JobOfferOut> exportAsList() {
        return service.exportAsList();
    }

    @RequestMapping(path = "/{jobofferid}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeById(@PathVariable("jobofferid") Long jobofferid) {
        service.removeById(jobofferid);
    }
}
