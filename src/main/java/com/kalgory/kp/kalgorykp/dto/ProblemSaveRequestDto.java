package com.kalgory.kp.kalgorykp.dto;

import com.kalgory.kp.kalgorykp.domain.problem.*;
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
