package com.workflow.workflowjobopening.services;

import com.workflow.workflowjobopening.models.Role;
import com.workflow.workflowjobopening.modelsIn.RoleIn;
import com.workflow.workflowjobopening.modelsOut.RoleOut;
import com.workflow.workflowjobopening.repositories.JobOfferRepository;
import com.workflow.workflowjobopening.repositories.RoleRepository;
import com.workflow.workflowjobopening.repositories.StageRepository;
import com.workflow.workflowjobopening.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<RoleOut> exportAsList(){
        return roleRepository.findAll().stream().map(p -> new RoleOut(p)).collect(Collectors.toList());
    }

    public Boolean importFromInput(RoleIn roleIn){

        final Role role = new Role(stageRepository.findOne(roleIn.getStage()),jobOfferRepository.findOne(roleIn.getJobOffer()),userRepository.findOne(roleIn.getUser()));
        roleRepository.save(role);
        roleRepository.flush();
        return true;
    }

    public void removeById (Long roleId){
        roleRepository.delete(roleId);
    }
}
