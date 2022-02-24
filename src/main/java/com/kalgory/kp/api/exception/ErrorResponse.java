package com.kalgory.kp.api.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

/**
 * 예외 발생 시 반환하는 응답 형태.
 */
@Getter
@Builder
public class ErrorResponse {

  private final LocalDateTime timestamp = LocalDateTime.now();
  private final int status;
  private final String error;
  private final String code;
  private final String message;

  /**
   * ErrorCode 열거형 객체로부터 ErrorResponse 인스턴스를 반환하는 정적 메서드.
   *
   * @param errorCode ErrorCode 열거형 객체
   * @return ErrorResponse 객체
   */
  public static ErrorResponse from(ErrorCode errorCode) {
    return ErrorResponse.builder()
        .status(errorCode.getStatus().value())
        .error(errorCode.getStatus().name())
        .code(errorCode.name())
        .message(errorCode.getMessage())
        .build();
  }
}
