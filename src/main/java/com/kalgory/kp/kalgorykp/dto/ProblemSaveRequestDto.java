package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.entity.problem.Problem;
import com.kalgory.kp.kalgorykp.entity.problem.ProblemLanguage;
import com.kalgory.kp.kalgorykp.entity.problem.ProblemLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemSaveRequestDto {

    private ProblemLevel level;
    private ProblemLanguage language;
    private String name;

    @Builder
    public ProblemSaveRequestDto(ProblemLevel level,
                                 ProblemLanguage language,
                                 String name) {
        this.level = level;
        this.language = language;
        this.name = name;
    }

    public Problem toEntity() {
        return Problem.builder()
                .level(level)
                .language(language)
                .name(name)
                .build();
    }
}
