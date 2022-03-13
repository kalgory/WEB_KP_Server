package com.kalgory.kp.api.dto;

import com.kalgory.kp.api.entity.problem.Problems;
import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import lombok.Getter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProblemReceiveResponseDto {
  private String id;
  private String level;
  private List<String> languages;
  private String name;
  private int finishedCount;

  public ProblemReceiveResponseDto(Problems problems){
    this.id = problems.getId();
    this.level = problems.getLevel().getValue();
    this.languages = problems.getLanguages().stream()
        .map(ProblemLanguage::getValue)
        .collect(Collectors.toList());
    this.name = problems.getName();
    this.finishedCount = problems.getFinishedCount();
  }
}
