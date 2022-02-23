package com.kalgory.kp.api.entity.problem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 문제 난이도 Enum Class.
 */
@Getter
@AllArgsConstructor
public enum ProblemLevel {
  NONE("NONE", "Level 0"),
  LEVEL_1("LEVEL_1", "Level 1"),
  LEVEL_2("LEVEL_2", "Level 2"),
  LEVEL_3("LEVEL_3", "Level 3"),
  LEVEL_4("LEVEL_4", "Level 4"),
  LEVEL_5("LEVEL_5", "Level 5");

  private final String code;
  private final String value;
}
