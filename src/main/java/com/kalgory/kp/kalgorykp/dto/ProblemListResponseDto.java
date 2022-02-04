package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ProblemListResponseDto {
    private final Long id;
    private final int level;
    private final List<String> languages;
    private final String name;
    private final int finished_count;

    public ProblemListResponseDto(Problem problem) {
        this.id = problem.getId();
        this.level = problem.getLevel().ordinal();
        this.languages = problem.getLanguages().stream()
                .map(Enum::toString)
                .collect(Collectors.toList());
        this.name = problem.getName();
        this.finished_count = problem.getFinished_count();
    }

    public ProblemListResponseDto(Long id, int level, List<String> languages, String name, int finished_count) {
        this.id = id;
        this.level = level;
        this.languages = languages;
        this.name = name;
        this.finished_count = finished_count;
    }
}
