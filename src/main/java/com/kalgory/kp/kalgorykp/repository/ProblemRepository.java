package com.kalgory.kp.kalgorykp.repository;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Spring Data JPA 와 DI 를 활용하기 위한 문제 repository interface.
 */
public interface ProblemRepository extends JpaRepository<Problem, Long>,
    JpaSpecificationExecutor<Problem> {

  @Query("SELECT problem FROM Problem problem ORDER BY problem.id ASC")
  List<ProblemListResponseDto> findAllAsc();
}
