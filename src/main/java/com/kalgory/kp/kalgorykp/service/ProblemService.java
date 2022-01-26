package com.kalgory.kp.kalgorykp.service;

import com.kalgory.kp.kalgorykp.dto.ProblemListResponseDto;
import com.kalgory.kp.kalgorykp.dto.ProblemSaveRequestDto;
import com.kalgory.kp.kalgorykp.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Transactional
    public Long save(ProblemSaveRequestDto problemSaveRequestDto){
        return problemRepository.save(problemSaveRequestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<ProblemListResponseDto> findAllAsc(){
        return problemRepository.findAll().stream()
                .map(ProblemListResponseDto::new)
                .collect(Collectors.toList());
    }

}
