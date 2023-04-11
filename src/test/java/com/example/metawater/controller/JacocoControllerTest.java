package com.example.metawater.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class JacocoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception{
        mvc.perform(get("/test")
                .param("n", "3"))
                .andExpect(content().string("hello"))
                .andExpect(status().isOk());

        mvc.perform(get("/test")
                        .param("n", "-1"))
                .andExpect(content().string("world"))
                .andExpect(status().isOk());
    }
}
