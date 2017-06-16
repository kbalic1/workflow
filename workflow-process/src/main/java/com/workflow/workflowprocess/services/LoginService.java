package com.workflow.workflowprocess.services;
import com.workflow.workflowprocess.models.User;
import com.workflow.workflowprocess.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Collection;
// import java.util.List;

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

    public User login(String email, String password) {
        return loginRepository.findByEmailAndPassword(email, password);
    }

}


