package com.learn.jwt.controller;

import com.learn.jwt.services.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private JwtService jwtService;
    public LoginController(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(Authentication auth){
         return jwtService.encode(auth);
    }
}
