package com.kalgory.kp.api.controller;

import com.kalgory.kp.api.dto.UserSignUpRequestDto;
import com.kalgory.kp.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 유저 관련 API Controller.
 */
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public void registerUser(UserSignUpRequestDto userSignUpRequestDto) {
    userService.signUp(userSignUpRequestDto);
  }
}
