package com.kalgory.kp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Spring Boot Application 실행.
 */
@SpringBootApplication
@EnableRedisHttpSession
public class KalgoryKpApplication {

  /**
   * entry point main function.
   *
   * @param args Process 인자.
   */
  public static void main(String[] args) {
    SpringApplication.run(KalgoryKpApplication.class, args);
  }

}
