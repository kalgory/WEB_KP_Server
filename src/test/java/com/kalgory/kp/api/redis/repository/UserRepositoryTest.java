package com.kalgory.kp.api.redis.repository;

import com.kalgory.kp.api.redis.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  void redis_Test() {
    // given
    String id = "test";
    User user = new User(id, "test@gmail.com");
    // when
    userRepository.save(user);
    // then
    boolean existsUser = userRepository.existsById(id);
    Assertions.assertThat(existsUser).isTrue();

    userRepository.delete(user);
  }
}