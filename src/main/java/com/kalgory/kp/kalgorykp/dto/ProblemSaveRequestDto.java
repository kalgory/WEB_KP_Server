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

    @Builder
    public ProblemSaveRequestDto(ProblemLevel level,
                                 ProblemLanguage language) {
        this.level = level;
        this.language = language;
    }

    public Problem toEntity() {
        return Problem.builder()
                .level(level)
                .language(language)
                .build();
    }
}
