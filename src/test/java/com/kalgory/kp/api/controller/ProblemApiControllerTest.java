package com.kalgory.kp.api.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kalgory.kp.api.entity.problem.Limit;
import com.kalgory.kp.api.entity.problem.Problems;
import com.kalgory.kp.api.entity.problem.Testcase;
import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.api.repository.ProblemRepository;
import java.util.ArrayList;
import java.util.List;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProblemApiControllerTest {

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
    problemRepository.deleteTopByOrderByIdDesc();
  }

  @Test
  @DisplayName("문제를 요청한다")
  public void requestProblem() throws Exception {
    //given
    String content = "테스트 문단";
    List<ProblemLanguage> languages = new ArrayList<ProblemLanguage>();
    languages.add(ProblemLanguage.C);
    int level = 1;
    String title = "Test";
    List<Testcase> testCases = new ArrayList<Testcase>();
    testCases.add(Testcase.builder().input("1+1").output("2").build());
    Limit limit = Limit.builder().time(1).memory(512).build();

    problemRepository.save(Problems.builder()
        .content(content)
        .level(level)
        .languages(languages)
        .title(title)
        .testcases(testCases)
        .limit(limit)
        .build());

    String url = "http://localhost:" + port + "/problems";

    //when
    mvc.perform(get(url))
        //then
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title", is(title)))
        .andExpect(jsonPath("$.level", is(level)))
        .andExpect(jsonPath("$.content", is(content)))
        .andExpect(jsonPath("$.testcases[0].input").exists())
        .andExpect(jsonPath("$.testcases[0].output").exists())
        .andExpect(jsonPath("$.limit.time").exists())
        .andExpect(jsonPath("$.limit.memory").exists());
  }
}