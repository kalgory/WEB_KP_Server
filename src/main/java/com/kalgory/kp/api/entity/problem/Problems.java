package com.kalgory.kp.api.entity.problem;

import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.api.entity.problem.enums.ProblemLevel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Problems Domain Document Class.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "problems")
public class Problems {

  @MongoId
  private String id;

  private ProblemLevel level;

  private List<ProblemLanguage> languages;

  private String name;

  private int finishedCount;

  public Problems(ProblemLevel level, List<ProblemLanguage> languages, String name, int finishedCount) {
    this.level = level;
    this.languages = languages;
    this.name = name;
    this.finishedCount = finishedCount;
  }
}
