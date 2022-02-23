package com.kalgory.kp.kalgorykp.service;

import com.kalgory.kp.kalgorykp.dto.UserSignUpRequestDto;
import com.kalgory.kp.kalgorykp.entity.user.Users;
import com.kalgory.kp.kalgorykp.repository.UsersRepository;
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
    // TODO: 글로벌 예외 처리
    if (usersRepository.existsByEmail(email)) {
      throw new IllegalStateException("이미 존재하는 유저입니다.");
    }
    String encodedPassword = passwordEncoder.encode(userSignUpRequestDto.getPassword());
    Users user = Users.of(userSignUpRequestDto, encodedPassword);
    usersRepository.save(user);
  }
}
