package com.kalgory.kp.kalgorykp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * 회원가입 시 사용하는 Dto Class.
 */
@Getter
@Builder
@AllArgsConstructor
public class UserSignUpRequestDto {

  private String email;
  private String password;
  private String username;
  private String profileImage;
}
