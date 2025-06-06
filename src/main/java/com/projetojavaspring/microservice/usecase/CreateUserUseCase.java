package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.jpa.UserRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.entity.UserEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.mapper.UserMapper;
import com.projetojavaspring.microservice.domain.UserDomain;
import com.projetojavaspring.microservice.domain.UserRequestDomain;
import com.projetojavaspring.microservice.usecase.exception.BusinessException;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

  private final UserRepository userRepository;

  public UserDomain execute(UserRequestDomain requestDomain) {
    UserDomain userDomain =
        UserDomain.builder()
            .username(requestDomain.getUsername())
            .email(requestDomain.getEmail())
            .password(requestDomain.getPassword())
            .fullName("Default Name")
            .bio("Default Bio")
            .posts(Collections.emptySet())
            .build();

    validateNewUser(userDomain);
    UserEntity userEntity =
        UserMapper.INSTANCE.toEntity(
            userDomain); // todo: Futuramente refatorar para uma interface -> userGateway
    UserEntity createdUser =
        this.userRepository.save(
            userEntity); // todo: Futuramente refatorar para uma interface -> userGateway

    return UserMapper.INSTANCE.toDomain(createdUser);
  }

  private void validateNewUser(UserDomain newUser) {
    validateUsername(newUser);
    validateUsernameExists(newUser);
    validateEmailExists(newUser);
  }

  private void validateUsername(UserDomain newUser) {
    if (newUser.getUsername().length() < 8) {
      throw new BusinessException("Username must be at least 8 characters");
    }
  }

  private void validateUsernameExists(UserDomain newUser) {
    var exists = userRepository.existsByUsername(newUser.getUsername());
    if (exists) {
      throw new BusinessException("Username already exists");
    }
  }

  private void validateEmailExists(UserDomain newUser) {
    var exists = userRepository.existsByEmail(newUser.getEmail());
    if (exists) {
      throw new BusinessException("Email already exists");
    }
  }
}
