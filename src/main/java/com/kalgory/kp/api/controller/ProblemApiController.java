package com.kalgory.kp.api.controller;

import com.kalgory.kp.api.dto.ProblemSaveRequestDto;
import com.kalgory.kp.api.service.ProblemService;
import lombok.RequiredArgsConstructor;
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
