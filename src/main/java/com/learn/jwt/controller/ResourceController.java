package com.learn.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/public")
    public String getPublic(){
        return "Welcome to a public page page";
    }

    @GetMapping("/private")
    public String getPrivate(){
        return "Welcome to a private page";
    }

}
