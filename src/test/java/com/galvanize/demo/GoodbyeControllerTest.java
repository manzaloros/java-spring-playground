package com.galvanize.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GoodbyeController.class)
public class GoodbyeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void controllerTest() throws Exception {
        this.mvc.perform(get("/bye"))
                .andExpect(status().isOk())
                .andExpect(content().string("Goodbye"));
    }
}
