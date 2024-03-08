package com.learn.jwt.controller;

import com.learn.jwt.model.UserRegistrationRequest;
import com.learn.jwt.services.UserRegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/user")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserRegistrationService userRegistrationService;
    @PostMapping("/register")
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        userRegistrationService.registerUser(userRegistrationRequest);
        log.info("User registered: {}", userRegistrationRequest);
    }

}
