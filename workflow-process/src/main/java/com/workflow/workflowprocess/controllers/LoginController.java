package com.workflow.workflowprocess.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.workflow.workflowprocess.services.LoginService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by valjic on 12/05/2017.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3002", "http://localhost:3004"})
@RequestMapping(value = "/api/login")
public class LoginController {


    private LoginService loginService;
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public String logged(@RequestHeader  String token) {

        JSONObject response = new JSONObject();

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("workflow-team")
                    .build(); //Reusable verifier instance
            DecodedJWT verifyJwt = verifier.verify(token);
            DecodedJWT jwt = JWT.decode(token);

            if (jwt.getClaim("role").asString().equals("User")){
                response.put("status", "OK");
                response.put("logged", true);
            } else {
                response.put("status", "NOT_OK");
                response.put("logged", false);
            }
            return response.toJSONString();

        } catch (UnsupportedEncodingException exception){
            response.put("status", "UTF-8 encoding not supported");
            response.put("logged", false);
            return response.toJSONString();
        } catch (JWTVerificationException exception){
            response.put("status", "Invalid signature/claims");
            response.put("logged", false);
            return response.toJSONString();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestHeader  String email,
                        @RequestHeader String password) {

        JSONObject response = new JSONObject();

        if (loginService.login(email, password) == null) {
            response.put("status", "NOT_OK");
            response.put("token", null);
            return response.toJSONString();
        }
        else {
            try {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                String token = JWT.create()
                        .withClaim("email", email)
                        .withClaim("role", "User")
                        .withIssuer("workflow-team")
                        .sign(algorithm);

                response.put("status", "OK");
                response.put("token", token);
                return response.toJSONString();

            } catch (UnsupportedEncodingException exception){
                //UTF-8 encoding not supported
                return "UTF-8 encoding not supported";
            } catch (JWTCreationException exception){
                //Invalid Signing configuration / Couldn't convert Claims.
                return "Invalid Signing configuration / Couldn't convert Claims.";
            }
        }
    }

}