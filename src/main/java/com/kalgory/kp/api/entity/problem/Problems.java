package com.kalgory.kp.api.entity.problem;

import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import javax.persistence.Embedded;

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

  private String content;

  private List<ProblemLanguage> languages;

  private int level;

  private String title;

  @Embedded
  private List<Testcase> testcases;

  @Embedded
  private Limit limit;

  public Problems(String content, List<ProblemLanguage> languages, int level, String title, List<Testcase> testcases, Limit limit) {
    this.content = content;
    this.languages = languages;
    this.level = level;
    this.title = title;
    this.testcases = testcases;
    this.limit = limit;
  }
}
