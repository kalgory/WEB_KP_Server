package com.kalgory.kp.api.controller;

import com.kalgory.kp.api.entity.problem.Problems;
import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.api.entity.problem.enums.ProblemLevel;
import com.kalgory.kp.api.repository.ProblemRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProblemAPiControllerTest {
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private ProblemRepository problemRepository;

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setup() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context)
        .build();
  }

  @After
  public void tearDown() throws Exception {
    problemRepository.deleteAll();
  }

  @Test
  @DisplayName("문제를 요청한다")
  public void requestProblem() throws Exception {
    //given
    ProblemLevel level = ProblemLevel.LEVEL_1;
    List<ProblemLanguage> languages = new ArrayList<ProblemLanguage>();
    languages.add(ProblemLanguage.C);
    String name = "Test";
    int finishedCount = 3;

    problemRepository.save(Problems.builder()
        .level(level)
        .languages(languages)
        .name(name)
        .finishedCount(finishedCount)
        .build());

    String url = "http://localhost:" + port + "/problems";

    //when
    mvc.perform(get(url))
        //then
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is(name)))
        .andExpect(jsonPath("$.level", is(level.getValue())))
        .andExpect(jsonPath("$.finishedCount", is(finishedCount)));
  }
}