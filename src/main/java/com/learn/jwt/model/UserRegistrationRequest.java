package com.learn.jwt.model;
public record UserRegistrationRequest(
        String username,
        String password,
        String email
){}
