package com.kalgory.kp.api.service;

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

}
