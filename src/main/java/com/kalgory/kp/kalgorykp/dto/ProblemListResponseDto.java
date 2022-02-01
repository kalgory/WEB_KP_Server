package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import lombok.Getter;

@Getter
public class ProblemListResponseDto {
    private final Long id;
    private final int level;
    private final String language;
    private final String name;
    private final int finished_count;

    public ProblemListResponseDto(Problem problem) {
        this.id = problem.getId();
        this.level = problem.getLevel().ordinal();
        this.language = problem.getLanguage().getValue();
        this.name = problem.getName();
        this.finished_count = problem.getFinished_count();
    }
}
