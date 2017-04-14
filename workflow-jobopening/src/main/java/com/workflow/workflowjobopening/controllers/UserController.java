package com.workflow.workflowjobopening.controllers;

import com.workflow.workflowjobopening.modelsIn.UserIn;
import com.workflow.workflowjobopening.modelsOut.UserOut;
import com.workflow.workflowjobopening.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST, consumes ="application/json")
    @ResponseBody
    public Boolean importJobOffer(@RequestBody UserIn input) {
        return service.importFromInput(input);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserOut> exportAsList() {
        return service.exportAsList();
    }

    @RequestMapping(path = "/{userid}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeById(@PathVariable("userid") Long userid) {
        service.removeById(userid);
    }
}
