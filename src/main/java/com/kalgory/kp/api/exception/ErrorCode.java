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
  DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일입니다."),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류입니다.");

  private final HttpStatus status;
  private final String message;
}
