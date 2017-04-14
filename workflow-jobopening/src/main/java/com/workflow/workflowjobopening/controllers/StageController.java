package com.workflow.workflowjobopening.controllers;

import com.workflow.workflowjobopening.modelsIn.StageIn;
import com.workflow.workflowjobopening.modelsOut.StageOut;
import com.workflow.workflowjobopening.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/stage", produces = "application/json")
public class StageController {

    @Autowired
    private StageService service;

    @RequestMapping(method = RequestMethod.POST, consumes ="application/json")
    @ResponseBody
    public Boolean importJobOffer(@RequestBody StageIn input) {
        return service.importFromInput(input);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<StageOut> exportAsList() {
        return service.exportAsList();
    }

    @RequestMapping(path = "/{stageid}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeById(@PathVariable("stageid") Long stageid) {
        service.removeById(stageid);
    }
}
