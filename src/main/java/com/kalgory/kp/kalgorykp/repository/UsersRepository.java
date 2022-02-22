package com.kalgory.kp.kalgorykp.repository;

import com.kalgory.kp.kalgorykp.entity.user.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Mongo DB와 연결하는 Repository.
 */
@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

  Boolean existsByUserId(String id);
}
