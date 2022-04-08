package com.kalgory.kp.api.service;

import com.kalgory.kp.api.dto.UserSignUpRequestDto;
import com.kalgory.kp.api.entity.user.Users;
import com.kalgory.kp.api.exception.CustomException;
import com.kalgory.kp.api.exception.ErrorCode;
import com.kalgory.kp.api.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 유저 관련 서비스 클래스.
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final PasswordEncoder passwordEncoder;
  private final UsersRepository usersRepository;

  /**
   * 회원가입 로직.
   *
   * @param userSignUpRequestDto 회원가입 시 요청한 데이터 DTO
   */
  public void signUp(UserSignUpRequestDto userSignUpRequestDto) {
    String email = userSignUpRequestDto.getEmail();
    validateEmail(email);

    Users user = Users.of(userSignUpRequestDto,
        passwordEncoder.encode(userSignUpRequestDto.getPassword()));
    usersRepository.save(user);
  }

  private void validateEmail(String email) {
    if (usersRepository.existsByEmail(email)) {
      throw new CustomException(ErrorCode.DUPLICATED_EMAIL);
    }
  }
}
