package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class VolumeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testVolume() throws Exception {
        this.mvc.perform(get("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("60"));

        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("60"));

        this.mvc.perform(patch("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("60"));

        this.mvc.perform(put("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("60"));

        this.mvc.perform(delete("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("60"));
    }
}
