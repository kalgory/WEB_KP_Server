package com.kalgory.kp.kalgorykp.controller;

import com.kalgory.kp.kalgorykp.dto.UserSignUpRequestDto;
import com.kalgory.kp.kalgorykp.service.UserService;
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
