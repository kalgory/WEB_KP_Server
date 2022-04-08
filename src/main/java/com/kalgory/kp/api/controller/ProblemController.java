package com.kalgory.kp.api.controller;

import com.kalgory.kp.api.dto.ProblemReceiveResponseDto;
import com.kalgory.kp.api.dto.ProblemSubmitRequestDto;
import com.kalgory.kp.api.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public ResponseEntity<ProblemReceiveResponseDto> receiveProblem(){
    ProblemReceiveResponseDto receive = problemService.receive();
    return ResponseEntity.ok(receive);
  }

  @PostMapping("/problems/submit")
  public ResponseEntity<String> submitProblem(@RequestBody ProblemSubmitRequestDto problemSubmitRequestDto){
    String result = problemService.submit(problemSubmitRequestDto);
    return ResponseEntity.accepted().body(result);
  }
}
