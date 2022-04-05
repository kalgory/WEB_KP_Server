package com.kalgory.kp.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 커스텀 예외에 사용되는 에러 코드.
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
  EMPTY_PROBLEM(HttpStatus.BAD_REQUEST, "문제가 존재하지 않습니다."),
  DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일입니다."),
  NO_SUCH_SESSION(HttpStatus.BAD_REQUEST, "세션 정보가 없습니다."),
  NO_COOKIES(HttpStatus.BAD_REQUEST, "쿠키가 없습니다."),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류입니다.");

  private final HttpStatus status;
  private final String message;
}
