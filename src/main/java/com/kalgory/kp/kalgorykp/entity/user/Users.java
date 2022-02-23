package com.kalgory.kp.kalgorykp.entity.user;

import com.kalgory.kp.kalgorykp.dto.UserSignUpRequestDto;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * users 컬렉션에 대응하는 document 클래스.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class Users {

  @Id
  private ObjectId id;

  private String password;

  private String profileImage;

  @Email
  private String email;

  private String username;

  /**
   * salt와 hash를 이용하여 Users 클래스를 생성하는 생성자.
   *
   * @param userSignUpRequestDto 회원가입 요청 Dto 클래스.
   * @param encodedPassword      인코딩된 비밀번호.
   * @return 암호화된 암호를 가진 Users 클래스.
   */
  public static Users of(UserSignUpRequestDto userSignUpRequestDto, String encodedPassword) {
    return Users.builder()
        .password(encodedPassword)
        .profileImage(userSignUpRequestDto.getProfileImage())
        .email(userSignUpRequestDto.getEmail())
        .username(userSignUpRequestDto.getUsername())
        .build();
  }
}
