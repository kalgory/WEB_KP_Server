package com.kalgory.kp.api.redis.repository;

import com.kalgory.kp.api.redis.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Redis 에서 User 객체를 다루기 위한 Repository.
 */
public interface UserRepository extends CrudRepository<User, String> {

}
