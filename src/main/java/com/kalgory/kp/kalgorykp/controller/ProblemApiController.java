package com.kalgory.kp.kalgorykp.controller;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProblemApiController {

    private final ProblemService problemService;

    @GetMapping("/problems")
    public List<ProblemListResponseDto> findAllChallenge(){
        return problemService.findMockData();
    }

    @PostMapping("/problems")
    public Long save(@RequestBody ProblemSaveRequestDto problemSaveRequestDto){
        return problemService.save(problemSaveRequestDto);
    }
}
