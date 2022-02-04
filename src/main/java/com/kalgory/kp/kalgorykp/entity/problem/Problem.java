package com.kalgory.kp.kalgorykp.entity.problem;

import com.kalgory.kp.kalgorykp.entity.problem.enums.*;
import com.kalgory.kp.kalgorykp.converter.ProblemLanguageConverter;
import com.kalgory.kp.kalgorykp.converter.ProblemLevelConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Convert(converter = ProblemLevelConverter.class)
    private ProblemLevel level;

    @Column(nullable = false)
    @Convert(converter = ProblemLanguageConverter.class)
    private ProblemLanguage language;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "int default 0")
    private int finished_count;
}
