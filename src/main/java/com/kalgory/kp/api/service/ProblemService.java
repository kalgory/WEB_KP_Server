package com.kalgory.kp.api.service;

import com.kalgory.kp.api.dto.ProblemReceiveResponseDto;
import com.kalgory.kp.api.dto.ProblemSubmitRequestDto;
import com.kalgory.kp.api.entity.problem.Problems;
import com.kalgory.kp.api.exception.CustomException;
import com.kalgory.kp.api.exception.ErrorCode;
import com.kalgory.kp.api.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 알고리즘 문제 관련 서비스 클래스.
 */
@RequiredArgsConstructor
@Service
public class ProblemService {

  private final ProblemRepository problemRepository;

  public ProblemReceiveResponseDto receive() {
    Problems problems = problemRepository.findTopByOrderByIdDesc()
        .orElseThrow(() -> new CustomException(ErrorCode.EMPTY_PROBLEM));

    return new ProblemReceiveResponseDto(problems);
  }

  public void submit(ProblemSubmitRequestDto problemSubmitRequestDto) {
    // 채점 서버 요청
  }

}