package com.kalgory.kp.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 전역 예외 핸들러.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  /**
   * 커스텀 예외를 처리하는 핸들러.
   *
   * @param customException 커스텀 예외 클래스
   * @return ErrorResponse 클래스
   */
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException customException) {
    log.error("handleCustomException: {}", customException.getErrorCode());
    return ResponseEntity
        .status(customException.getErrorCode().getStatus().value())
        .body(ErrorResponse.from(customException.getErrorCode()));
  }

  /**
   * 커스텀 예외를 제외한 모든 예외를 처리하는 핸들러.
   *
   * @param exception 최상위 예외 클래스
   * @return ErrorResponse 클래스
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleAllException(Exception exception) {
    log.error("handleAllException: {}", exception.getMessage());
    return ResponseEntity
        .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
        .body(ErrorResponse.from(ErrorCode.INTERNAL_SERVER_ERROR));
  }
}
