package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

/**
 * 문제 리스트 반환 DTO.
 */
@Getter
@Builder
public class ProblemListResponseDto {

  private final Long id;
  private final int level;
  private final List<String> languages;
  private final String name;
  private final int finishedCount;

  /**
   * 문제 Entity 를 통해 DTO 를 구성하는 생성자.
   *
   * @param problem Problem Entity Instance.
   */
  public ProblemListResponseDto(Problem problem) {
    this.id = problem.getId();
    this.level = problem.getLevel().ordinal();
    this.languages = problem.getLanguages().stream()
        .map(Enum::toString)
        .collect(Collectors.toList());
    this.name = problem.getName();
    this.finishedCount = problem.getFinishedCount();
  }

  /**
   * 문제에 필요한 정보를 바탕으로 DTO 를 구성하는 생성자.
   *
   * @param id            문제 식별자.
   * @param level         문제 난이도.
   * @param languages     문제 사용가능 언어.
   * @param name          문제 이름.
   * @param finishedCount 문제 정답자 수.
   */
  public ProblemListResponseDto(Long id, int level, List<String> languages, String name,
      int finishedCount) {
    this.id = id;
    this.level = level;
    this.languages = languages;
    this.name = name;
    this.finishedCount = finishedCount;
  }
}
