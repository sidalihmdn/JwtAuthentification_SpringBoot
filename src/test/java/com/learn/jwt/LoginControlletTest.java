package com.learn.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControlletTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessfulLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .with(httpBasic("user", "password")))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFailedLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .with(httpBasic("user", "wrongpassword")))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
}
