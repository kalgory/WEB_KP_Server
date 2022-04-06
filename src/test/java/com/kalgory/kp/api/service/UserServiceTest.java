package com.kalgory.kp.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kalgory.kp.api.dto.UserSignUpRequestDto;
import com.kalgory.kp.api.exception.CustomException;
import com.kalgory.kp.api.exception.ErrorCode;
import com.kalgory.kp.api.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UsersRepository usersRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Test
  @DisplayName("회원가입 정상 흐름")
  void signUp() {
    // given
    String email = "test@gmail.com";
    String password = "test";
    UserSignUpRequestDto userSignUpRequestDto = UserSignUpRequestDto.builder()
        .email(email)
        .password(password)
        .username("test")
        .profileImage("test.jpg")
        .build();
    // when
    when(usersRepository.existsByEmail(email)).thenReturn(false);
    when(usersRepository.save(Mockito.any())).thenReturn(Mockito.any());
    when(passwordEncoder.encode(password)).thenReturn(password);
    // then
    Assertions.assertDoesNotThrow(() -> userService.signUp(userSignUpRequestDto));
    verify(usersRepository).existsByEmail(email);
    verify(usersRepository).save(Mockito.any());
    verify(passwordEncoder).encode(password);
  }

  @Test
  @DisplayName("중복 이메일로 회원가입 시도")
  void signUpDuplicateEmail() {
    // given
    String email = "test@gmail.com";
    String password = "test";
    UserSignUpRequestDto userSignUpRequestDto = UserSignUpRequestDto.builder()
        .email(email)
        .password(password)
        .username("test")
        .profileImage("test.jpg")
        .build();
    // when
    when(usersRepository.existsByEmail(email)).thenReturn(true);
    // then
    CustomException customException = assertThrowsExactly(CustomException.class,
        () -> userService.signUp(userSignUpRequestDto));
    assertThat(customException.getErrorCode()).isEqualTo(ErrorCode.DUPLICATED_EMAIL);
    verify(usersRepository).existsByEmail(email);
    verify(usersRepository, never()).save(Mockito.any());
    verify(passwordEncoder, never()).encode(password);
  }
}