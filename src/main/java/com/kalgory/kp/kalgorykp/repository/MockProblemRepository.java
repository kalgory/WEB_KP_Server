package com.kalgory.kp.kalgorykp.repository;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MockProblemRepository {
    private final ClassPathResource resource = new ClassPathResource("static/mock/mock-data.json");

    public List<ProblemListResponseDto> findAll() {
        List<ProblemListResponseDto> responseDtoList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream())) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(inputStreamReader);

            jsonArray.forEach(obj -> {
                JSONObject problem = (JSONObject) obj;
                List<String> languages = (List<String>) (problem.get("languages"));

                responseDtoList.add(ProblemListResponseDto.builder()
                        .id((Long) problem.get("id"))
                        .level(((Long) problem.get("level")).intValue())
                        .languages(languages)
                        .finished_count(((Long) problem.get("finished_count")).intValue())
                        .name((String) problem.get("name"))
                        .build());
            });
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return responseDtoList;
    }
}
