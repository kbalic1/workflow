package com.workflow.workflowapplications.services;
import com.workflow.workflowapplications.models.Applicant;
import com.workflow.workflowapplications.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workflow.workflowapplications.repositories.ApplicantRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by valjic on 12/05/2017.
 */
@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public void setLoginRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Applicant login(String email, String password) {
        return loginRepository.findByEmailAndPassword(email, password);
    }

}


