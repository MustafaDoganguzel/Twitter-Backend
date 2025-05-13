package com.springAndJava.twitterClone.controller;

import com.springAndJava.twitterClone.dto.RegistrationUser;
import com.springAndJava.twitterClone.entity.User;
import com.springAndJava.twitterClone.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {
    private AuthenticationService authenticationService;
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationUser registrationUser){
        return authenticationService.register(registrationUser.username(),
                registrationUser.email(), registrationUser.password());

    }
}