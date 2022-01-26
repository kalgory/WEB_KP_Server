package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.domain.problem.*;
import lombok.Getter;

@Getter
public class ProblemListResponseDto {
    private final Long id;
    private final String level;
    private final String language;

    public ProblemListResponseDto(Problem problem) {
        this.id = problem.getId();
        this.level = problem.getLevel().getValue();
        this.language = problem.getLanguage().getValue();
    }
}
