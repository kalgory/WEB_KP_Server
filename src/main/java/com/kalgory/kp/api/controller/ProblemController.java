package com.kalgory.kp.api.controller;

import com.kalgory.kp.api.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * 문제 관련 API Controller.
 */
@RestController
@RequiredArgsConstructor
public class ProblemController {

  private final ProblemService problemService;

}
