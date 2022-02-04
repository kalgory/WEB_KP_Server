package com.kalgory.kp.kalgorykp.converter;

import com.kalgory.kp.kalgorykp.entity.problem.enums.ProblemLanguage;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemLanguageConverter implements AttributeConverter<List<ProblemLanguage>, String> {
    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<ProblemLanguage> attribute) {
        return attribute.stream().map(ProblemLanguage::getCode).collect(Collectors.joining(DELIMITER));
    }

    @Override
    public List<ProblemLanguage> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(DELIMITER))
                .map(ProblemLanguage::valueOf)
                .collect(Collectors.toList());
    }
}
