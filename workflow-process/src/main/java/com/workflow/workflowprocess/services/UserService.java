package com.workflow.workflowprocess.services;

import com.workflow.workflowprocess.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workflow.workflowprocess.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
/**
 * Created by Tarik on 4/8/17.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public User get(Long id) {
        return userRepository.findOne(id);
    }

    public Collection<User> getAllWithFirstName(String firstName){
        return userRepository.getAllWithFirstName(firstName);
    }

    public Collection<User> getUsers(String firstName, String lastName, String email){
        return userRepository.findByFirstNameAndLastNameAndEmail(firstName, lastName, email);
    }

    public Long add(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public void update(User user) {
        if (userRepository.exists(user.getId())) {
            userRepository.save(user);
        }
    }
}
