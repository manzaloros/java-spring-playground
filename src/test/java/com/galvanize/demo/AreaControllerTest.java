package com.galvanize.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AreaController.class)
public class AreaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void circle() throws Exception {
        String expectedResponse =
                "Area of a circle with a radius of 4 is 50.26548245743669";
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void rectangle() throws Exception {
        String expectedResponse = "Area of a 4x7 rectangle is 28";

        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height", "7");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void invalidTest() throws Exception {
        String expectedResponse = "Invalid";

        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

}
