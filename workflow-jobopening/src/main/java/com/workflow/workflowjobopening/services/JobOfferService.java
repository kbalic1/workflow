package com.workflow.workflowjobopening.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.io.UnsupportedEncodingException;
import com.workflow.workflowjobopening.models.JobOffer;
import com.workflow.workflowjobopening.models.User;
import com.workflow.workflowjobopening.modelsIn.JobOfferIn;
import com.workflow.workflowjobopening.modelsOut.JobOfferOut;
import com.workflow.workflowjobopening.repositories.JobOfferRepository;
import com.workflow.workflowjobopening.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private UserRepository userRepository;

    private Algorithm algorithm;
    private JWTVerifier verifier;

    public JobOfferOut getById(Long id) {

        return  new JobOfferOut(jobOfferRepository.findOne(id));
    }

    public List<JobOfferOut> exportAsList(){
        return jobOfferRepository.findAll().stream().map(p -> new JobOfferOut(p)).collect(Collectors.toList());
    }

    public List<JobOfferOut> getAllPublishedJobOffers(){
        return jobOfferRepository.findAllByPublished(true).stream().map(p -> new JobOfferOut(p)).collect(Collectors.toList());
    }

    public List<JobOfferOut> getAllBeforeDate(String date){

        Date dateBefore = new Date();
        try {
            dateBefore = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {

        }

        return jobOfferRepository.getAllBeforeDeadlineDate(dateBefore);
    }

    public Boolean importFromInput(JobOfferIn jobOfferIn){
        try {
            algorithm = Algorithm.HMAC256("secret");
            verifier = JWT.require(algorithm)
                    .withIssuer("workflow-team")
                    .build(); //Reusable verifier instance
            DecodedJWT verifyJwt = verifier.verify(jobOfferIn.getToken());
            DecodedJWT jwt = JWT.decode(jobOfferIn.getToken());
            String username = jwt.getClaim("email").toString();
            User user = userRepository.findByEmail(username);
            final JobOffer jobOffer = new JobOffer(jobOfferIn, user);
            jobOfferRepository.save(jobOffer);
            jobOfferRepository.flush();
            return true;

        } catch (UnsupportedEncodingException exception){

        } catch (JWTVerificationException exception){

        }
        return false;
    }

    public void removeById (Long jobOfferId){
        jobOfferRepository.delete(jobOfferId);
    }
}
