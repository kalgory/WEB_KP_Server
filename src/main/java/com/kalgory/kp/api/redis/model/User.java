package com.kalgory.kp.api.redis.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

/**
 * Redis 에서 저장하는 User 데이터 구조.
 */
@Getter
@AllArgsConstructor
@RedisHash("user")
public class User {

  @Id
  private String id;
  private String email;
}
