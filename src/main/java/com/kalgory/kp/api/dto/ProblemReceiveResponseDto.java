package com.kalgory.kp.api.dto;

import com.kalgory.kp.api.entity.problem.Limit;
import com.kalgory.kp.api.entity.problem.Problems;
import com.kalgory.kp.api.entity.problem.Testcase;
import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import lombok.Getter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProblemReceiveResponseDto {
  private String id;
  private String content;
  private int level;
  private List<String> languages;
  private String title;
  private List<Testcase> testcases;
  private Limit limit;

  public ProblemReceiveResponseDto(Problems problems){
    this.id = problems.getId();
    this.content = problems.getContent();
    this.level = problems.getLevel();
    this.languages = problems.getLanguages().stream()
        .map(ProblemLanguage::getValue)
        .collect(Collectors.toList());
    this.title = problems.getTitle();
    this.testcases = problems.getTestcases();
    this.limit = problems.getLimit();
  }
}
