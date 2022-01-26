package com.kalgory.kp.kalgorykp.converter;

import com.kalgory.kp.kalgorykp.domain.problem.ProblemLanguage;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class ProblemLanguageConverter implements AttributeConverter<ProblemLanguage, String> {
    @Override
    public String convertToDatabaseColumn(ProblemLanguage attribute) {
        return attribute.getCode();
    }

    @Override
    public ProblemLanguage convertToEntityAttribute(String dbData) {
        return Arrays.stream(ProblemLanguage.values())
                .filter(problemLanguage -> problemLanguage.getCode().equals(dbData))
                .findAny()
                .orElseThrow();
    }
}
