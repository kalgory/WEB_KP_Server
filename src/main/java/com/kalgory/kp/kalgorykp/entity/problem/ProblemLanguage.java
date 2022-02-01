package com.kalgory.kp.kalgorykp.entity.problem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProblemLanguage {
    C("C", "C"),
    CPP("CPP", "C++"),
    JAVA("JAVA", "Java"),
    CSHARP("CSHARP", "C#"),
    KOTLIN("KOTLIN", "Kotlin"),
    JAVASCRIPT("JAVASCRIPT", "Javascript");

    private final String code;
    private final String value;
}
