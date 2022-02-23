package com.kalgory.kp.api.converter;

import com.kalgory.kp.api.entity.problem.enums.ProblemLevel;
import java.util.Arrays;
import javax.persistence.AttributeConverter;

/**
 * Database Record 와 Problem Level Converter.
 */
public class ProblemLevelConverter implements AttributeConverter<ProblemLevel, String> {

  @Override
  public String convertToDatabaseColumn(ProblemLevel attribute) {
    return attribute.getCode();
  }

  @Override
  public ProblemLevel convertToEntityAttribute(String dbData) {
    return Arrays.stream(ProblemLevel.values())
        .filter(problemLevel -> problemLevel.getCode().equals(dbData))
        .findAny()
        .orElseThrow();
  }
}
