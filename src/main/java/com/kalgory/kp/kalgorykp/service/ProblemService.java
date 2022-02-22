package com.kalgory.kp.kalgorykp.service;

import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 알고리즘 문제 관련 Service Layer.
 */
@RequiredArgsConstructor
@Service
public class ProblemService {

  private final ProblemRepository problemRepository;

  /**
   * 문제 하나 저장하는 Logic.
   *
   * @param problemSaveRequestDto 문제 저장관련 DTO Class.
   * @return 저장된 문제의 id.
   */
  @Transactional
  public Long save(ProblemSaveRequestDto problemSaveRequestDto) {
    return problemRepository.save(problemSaveRequestDto.toEntity()).getId();
  }
}
