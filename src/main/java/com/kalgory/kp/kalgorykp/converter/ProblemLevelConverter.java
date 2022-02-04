package com.kalgory.kp.kalgorykp.converter;

import com.kalgory.kp.kalgorykp.entity.problem.enums.ProblemLevel;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

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
