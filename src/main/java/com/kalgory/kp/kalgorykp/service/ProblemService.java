package com.kalgory.kp.kalgorykp.service;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.repository.MockProblemRepository;
import com.kalgory.kp.kalgorykp.repository.ProblemRepository;
import java.util.List;
import java.util.stream.Collectors;
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
  private final MockProblemRepository mockProblemRepository;

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

  /**
   * 모든 문제 찾는 Logic.
   *
   * @return 문제 리스트.
   */
  @Transactional(readOnly = true)
  public List<ProblemListResponseDto> findAllAsc() {
    return problemRepository.findAll().stream()
        .map(ProblemListResponseDto::new)
        .collect(Collectors.toList());
  }


  /**
   * mocking data 반환하는 Logic.
   *
   * @return mocking 된 문제정보 리스트.
   */
  @Transactional(readOnly = true)
  public List<ProblemListResponseDto> findMockData() {
    return mockProblemRepository.findAll();
  }

}
