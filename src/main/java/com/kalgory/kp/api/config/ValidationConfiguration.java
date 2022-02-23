package com.kalgory.kp.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * MongoDB 데이터 유효성 검사 설정.
 */
@Configuration
public class ValidationConfiguration {

  @Bean
  public ValidatingMongoEventListener validatingMongoEventListener(
      LocalValidatorFactoryBean factory) {
    return new ValidatingMongoEventListener(factory);
  }
}