package com.projetojavaspring.microservice.domain.usecase;

import com.projetojavaspring.microservice.domain.model.UserDomain;
import com.projetojavaspring.microservice.domain.model.UserRequestDomain;
import com.projetojavaspring.microservice.entity.UserEntity;
import com.projetojavaspring.microservice.mapper.UserMapper;
import com.projetojavaspring.microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public UserDomain execute(UserRequestDomain requestDomain) {
        UserDomain userDomain = UserDomain.builder()
                .username(requestDomain.getUsername())
                .email(requestDomain.getEmail())
                .password(requestDomain.getPassword())
                .fullName("Default Name")
                .bio("Default Bio")
                .build();

        validateUsername(userDomain);
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDomain);
        UserEntity createdUser = this.userRepository.save(userEntity);

        return UserMapper.INSTANCE.toDomain(createdUser);
    }

    private void validateUsername(UserDomain newUser){
        if(newUser.getUsername().length()<8){
            throw new IllegalArgumentException("Username must be at least 8 characters");
        }
    }
}
