package com.kalgory.kp.kalgorykp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalgory.kp.kalgorykp.domain.problem.*;
import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.repository.ProblemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProblemApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @AfterEach
    void tearDown() {
        problemRepository.deleteAll();
    }

    @Test
    @DisplayName("Save Challenge Test")
    void save() throws Exception {
        //given
        String level = "LEVEL_1";
        String language = "JAVA";

        ProblemSaveRequestDto requestDto = ProblemSaveRequestDto.builder()
                .level(ProblemLevel.valueOf(level))
                .language(ProblemLanguage.valueOf(language))
                .build();

        String url = "http://localhost:" + port + "/problems";
        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
        //then
        List<Problem> all = problemRepository.findAll();
        assertThat(all.get(0).getLevel().getCode()).isEqualTo(level);
        assertThat(all.get(0).getLanguage().getCode()).isEqualTo(language);
    }

    @Test
    void findAllChallenge() throws Exception {
        //given
        String level = "LEVEL_1";
        String language = "CPP";

        Problem problem = Problem.builder()
                .level(ProblemLevel.valueOf(level))
                .language(ProblemLanguage.valueOf(language))
                .build();

        problemRepository.save(problem);

        String url = "http://localhost:" + port + "/problems";
        //when
        //then
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].level", is("Level 1")))
                .andExpect(jsonPath("$[0].language", is("C++")));
    }
}