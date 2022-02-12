package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import com.kalgory.kp.kalgorykp.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.kalgorykp.entity.problem.enums.ProblemLevel;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 문제 저장 관련 DTO Class.
 */
@Getter
@NoArgsConstructor
public class ProblemSaveRequestDto {

  private ProblemLevel level;
  private List<ProblemLanguage> languages;
  private String name;

  /**
   * 문제 저장 DTO 생성자.
   *
   * @param level     문제 난이도 Enum.
   * @param languages 문제 사용가능 언어 Enum.
   * @param name      문제 이름.
   */
  @Builder
  public ProblemSaveRequestDto(ProblemLevel level,
      List<ProblemLanguage> languages,
      String name) {
    this.level = level;
    this.languages = languages;
    this.name = name;
  }

  /**
   * Problem Entity 로 변환하는 method.
   *
   * @return Problem Entity Class.
   */
  public Problem toEntity() {
    return Problem.builder()
        .level(level)
        .languages(languages)
        .name(name)
        .build();
  }
}
