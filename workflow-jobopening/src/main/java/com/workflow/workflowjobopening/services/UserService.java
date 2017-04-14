package com.workflow.workflowjobopening.services;

import com.workflow.workflowjobopening.models.User;
import com.workflow.workflowjobopening.modelsIn.UserIn;
import com.workflow.workflowjobopening.modelsOut.UserOut;
import com.workflow.workflowjobopening.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserOut> exportAsList(){
        return userRepository.findAll().stream().map(p -> new UserOut(p)).collect(Collectors.toList());
    }

    public Boolean importFromInput(UserIn userIn){

        final User jobOffer = new User(userIn);
        userRepository.save(jobOffer);
        userRepository.flush();
        return true;
    }

    public void removeById (Long jobOfferId){
        userRepository.delete(jobOfferId);
    }
}
