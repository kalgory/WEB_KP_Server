package com.kalgory.kp.api.entity.problem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.persistence.Embeddable;

@Getter
@Builder
@AllArgsConstructor
@Embeddable
public class Limit {
  private int time;
  private long memory;
}
