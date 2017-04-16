package com.workflow.workflowprocess.controllers;

import com.workflow.workflowprocess.models.Evaluation;
import com.workflow.workflowprocess.models.User;
import com.workflow.workflowprocess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getUsers(@RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName,
                                                 @RequestParam("email") String email) {
        return userService.getUsers(firstName, lastName, email);
    }

    @RequestMapping(value = "/name/{firstName}", method = RequestMethod.GET)
    public Collection<User> getAllWithFirstName(@PathVariable("firstName") String firstName) {
        return userService.getAllWithFirstName(firstName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        Long userId = userService.add(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(userId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id,
                                              @RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().build();
    }


}