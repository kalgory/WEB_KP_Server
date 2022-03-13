package com.kalgory.kp.api.controller;

import com.kalgory.kp.api.dto.ProblemReceiveResponseDto;
import com.kalgory.kp.api.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 문제 관련 API Controller.
 */
@RestController
@RequiredArgsConstructor
public class ProblemController {

  private final ProblemService problemService;

  @GetMapping("/problems")
  @ResponseStatus(HttpStatus.OK)
  public ProblemReceiveResponseDto receiveProblem(){
    return problemService.receive();
  }
}
