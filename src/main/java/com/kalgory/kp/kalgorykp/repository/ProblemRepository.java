package com.kalgory.kp.kalgorykp.repository;

import com.kalgory.kp.kalgorykp.domain.problem.Problem;
import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long>, JpaSpecificationExecutor<Problem> {

    @Query("SELECT problem FROM Problem problem ORDER BY problem.id ASC")
    List<ProblemListResponseDto> findAllAsc();
}
