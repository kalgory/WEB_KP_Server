package com.kalgory.kp.kalgorykp.controller;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.service.ProblemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 문제 관련 API Controller.
 */
@RestController
@RequiredArgsConstructor
public class ProblemApiController {

  private final ProblemService problemService;

  /**
   * Challenge 관련 모든 문제 리스트 GET API.
   *
   * @return 조건에 맞는 문제 리스트.
   */
  @GetMapping("/problems")
  public List<ProblemListResponseDto> findAllChallenge() {
    return problemService.findMockData();
  }

  /**
   * 문제 저장 POST API.
   *
   * @param problemSaveRequestDto 문제 저장 요청 DTO Class.
   * @return 저장된 문제 id.
   */
  @PostMapping("/problems")
  public Long save(@RequestBody ProblemSaveRequestDto problemSaveRequestDto) {
    return problemService.save(problemSaveRequestDto);
  }
}
