package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import com.kalgory.kp.kalgorykp.entity.problem.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProblemSaveRequestDto {

    private ProblemLevel level;
    private List<ProblemLanguage> languages;
    private String name;

    @Builder
    public ProblemSaveRequestDto(ProblemLevel level,
                                 List<ProblemLanguage> languages,
                                 String name) {
        this.level = level;
        this.languages = languages;
        this.name = name;
    }

    public Problem toEntity() {
        return Problem.builder()
                .level(level)
                .languages(languages)
                .name(name)
                .build();
    }
}
