package com.kalgory.kp.kalgorykp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired private MockMvc mvc;

    @Test
    void hello() throws Exception {
        //given
        String name = "테스트입니다.";

        //when then
        mvc.perform(get("/hello")
                .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string("hello " + name));
    }
}