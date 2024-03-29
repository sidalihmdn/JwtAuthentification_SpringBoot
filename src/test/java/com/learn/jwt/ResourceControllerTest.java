package com.learn.jwt;


import com.learn.jwt.controller.ResourceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    // test if we can access the public page
    @Test
    public void testPublic() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/public"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // test if we can access the private page
    @Test
    public void testPrivate() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/private"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }


}
