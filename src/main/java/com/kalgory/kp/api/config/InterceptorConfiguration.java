package com.kalgory.kp.api.config;

import com.kalgory.kp.api.interceptor.SessionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 인터셉터 등록을 위한 설정.
 */
@RequiredArgsConstructor
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

  private final SessionInterceptor sessionInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(sessionInterceptor)
        .addPathPatterns("/*")
        .excludePathPatterns("/sign-up");
  }
}
