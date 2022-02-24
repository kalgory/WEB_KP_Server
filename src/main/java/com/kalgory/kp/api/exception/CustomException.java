package com.kalgory.kp.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UncheckedException을 처리하기 위한 커스텀 예외 클래스.
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

  private final ErrorCode errorCode;
}
