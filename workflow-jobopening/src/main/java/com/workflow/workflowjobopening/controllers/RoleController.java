package com.workflow.workflowjobopening.controllers;

import com.workflow.workflowjobopening.modelsIn.RoleIn;
import com.workflow.workflowjobopening.modelsOut.RoleOut;
import com.workflow.workflowjobopening.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/role", produces = "application/json")
public class RoleController {

    @Autowired
    private RoleService service;

    @RequestMapping(method = RequestMethod.POST, consumes ="application/json")
    @ResponseBody
    public Boolean importJobOffer(@RequestBody RoleIn input) {
        return service.importFromInput(input);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RoleOut> exportAsList() {
        return service.exportAsList();
    }

    @RequestMapping(path = "/{roleid}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeById(@PathVariable("roleid") Long roleId) {
        service.removeById(roleId);
    }
}
