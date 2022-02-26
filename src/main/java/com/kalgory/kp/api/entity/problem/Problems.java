package com.kalgory.kp.api.entity.problem;

import com.kalgory.kp.api.entity.problem.enums.ProblemLanguage;
import com.kalgory.kp.api.entity.problem.enums.ProblemLevel;
import java.util.List;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Problems Domain Document Class.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "problems")
public class Problems {

  @Id
  private Long id;

  private ProblemLevel level;

  private List<ProblemLanguage> languages;

  private String name;

  private int finishedCount;
}
