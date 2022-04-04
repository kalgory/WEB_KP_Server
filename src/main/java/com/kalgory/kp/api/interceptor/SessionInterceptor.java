package com.kalgory.kp.api.interceptor;

import com.kalgory.kp.api.exception.CustomException;
import com.kalgory.kp.api.exception.ErrorCode;
import com.kalgory.kp.api.redis.repository.UserRepository;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Redis 세션 정보를 확인하는 인터셉터.
 */
@RequiredArgsConstructor
@Component
public class SessionInterceptor implements HandlerInterceptor {

  private final UserRepository userRepository;
  private static final String SESSION = "session";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    String sessionValue = getSession(request);
    validateSession(sessionValue);
    return true;
  }

  private void validateSession(String sessionValue) {
    boolean existsSession = userRepository.existsById(sessionValue);
    if (!existsSession) {
      throw new CustomException(ErrorCode.NO_SUCH_SESSION);
    }
  }

  private String getSession(HttpServletRequest request) {
    return Arrays.stream(request.getCookies())
        .filter(cookie -> cookie.getName().equals(SESSION))
        .findFirst().orElseThrow().getValue();
  }
}
