package com.learn.jwt;


import com.learn.jwt.controller.ResourceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResourceControllerTest {

    @Autowired
    private ResourceController resourceController;

    @Test
    public void testGetRoot(){
        String result = resourceController.getRoot();
        assert(result.equals("Welcome to the home page"));
    }
}
