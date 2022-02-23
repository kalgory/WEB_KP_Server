package com.kalgory.kp.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalgory.kp.api.dto.ProblemSaveRequestDto;
import com.kalgory.kp.api.entity.problem.Problem;
import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.api.entity.problem.enums.ProblemLevel;
import com.kalgory.kp.api.repository.ProblemRepository;
import java.util.List;
import java.util.stream.Collectors;
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
    public void setup() {
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
        List<String> languages = List.of("JAVA", "CPP");
        String name = "테스트";

        ProblemSaveRequestDto requestDto = ProblemSaveRequestDto.builder()
                .level(ProblemLevel.values()[level])
                .languages(languages.stream()
                        .map(ProblemLanguage::valueOf)
                        .collect(Collectors.toList()))
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
        assertThat(all.get(0).getLanguages().stream()
                .map(ProblemLanguage::getCode)
                .collect(Collectors.toList()))
                .isEqualTo(languages);
        assertThat(all.get(0).getName()).isEqualTo(name);
    }
}