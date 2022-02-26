package com.kalgory.kp.api.repository;

import com.kalgory.kp.api.entity.problem.Problems;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Mongo DB의 problems 컬렉션과 연결하는 Repository.
 */
public interface ProblemRepository extends MongoRepository<Problems, Long> {

}
