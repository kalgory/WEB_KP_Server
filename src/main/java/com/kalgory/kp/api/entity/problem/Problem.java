package com.kalgory.kp.api.entity.problem;

import com.kalgory.kp.api.converter.ProblemLanguageConverter;
import com.kalgory.kp.api.converter.ProblemLevelConverter;
import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.api.entity.problem.enums.ProblemLevel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Problem Domain Entity Class.
 */
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
  private List<ProblemLanguage> languages;

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "int default 0")
  private int finishedCount;
}
