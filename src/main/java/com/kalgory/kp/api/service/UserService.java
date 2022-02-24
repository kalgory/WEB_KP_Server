package com.kalgory.kp.api.service;

import com.kalgory.kp.api.dto.UserSignUpRequestDto;
import com.kalgory.kp.api.entity.user.Users;
import com.kalgory.kp.api.exception.CustomException;
import com.kalgory.kp.api.exception.ErrorCode;
import com.kalgory.kp.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 유저와 관련된 로직을 처리하는 서비스.
 */
@Service
public class UserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UsersRepository usersRepository;

  /**
   * 회원가입 로직.
   *
   * @param userSignUpRequestDto 회원가입 시 요청한 데이터 DTO
   */
  public void signUp(UserSignUpRequestDto userSignUpRequestDto) {
    String email = userSignUpRequestDto.getEmail();

    if (usersRepository.existsByEmail(email)) {
      throw new CustomException(ErrorCode.DUPLICATED_EMAIL);
    }
    String encodedPassword = passwordEncoder.encode(userSignUpRequestDto.getPassword());
    Users user = Users.of(userSignUpRequestDto, encodedPassword);
    usersRepository.save(user);
  }
}
