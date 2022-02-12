package com.kalgory.kp.kalgorykp.repository;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

/**
 * Mocking Problem 데이터 Repository 클래스.
 */
@Repository
public class MockProblemRepository {

  private final ClassPathResource resource = new ClassPathResource("static/mock/mock-data.json");

  /**
   * mocking 된 모든 문제 Method.
   *
   * @return 모든 문제 리스트.
   */
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
