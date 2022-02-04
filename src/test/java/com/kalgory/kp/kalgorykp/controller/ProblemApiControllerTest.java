package com.kalgory.kp.kalgorykp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalgory.kp.kalgorykp.entity.problem.enums.*;
import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.entity.problem.*;
import com.kalgory.kp.kalgorykp.repository.ProblemRepository;
import org.junit.jupiter.api.*;
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
        int level = 3;
        String language = "JAVA";
        String name = "테스트";

        ProblemSaveRequestDto requestDto = ProblemSaveRequestDto.builder()
                .level(ProblemLevel.values()[level])
                .language(ProblemLanguage.valueOf(language))
                .name(name)
                .build();

        String url = "http://localhost:" + port + "/problems";
        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
        //then
        List<Problem> all = problemRepository.findAll();
        assertThat(all.get(0).getLevel().ordinal()).isEqualTo(level);
        assertThat(all.get(0).getLanguage().getCode()).isEqualTo(language);
        assertThat(all.get(0).getName()).isEqualTo(name);
    }

    @Test
    void findAllProblem() throws Exception {
        //given
        int level = 1;
        String language = "CPP";
        String name = "테스트";

        Problem problem = Problem.builder()
                .level(ProblemLevel.values()[level])
                .language(ProblemLanguage.valueOf(language))
                .name(name)
                .build();

        problemRepository.save(problem);

        String url = "http://localhost:" + port + "/problems";
        //when
        //then
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].level", is(level)))
                .andExpect(jsonPath("$[0].language", is("C++")))
                .andExpect(jsonPath("$[0].name", is(name)));
    }
}