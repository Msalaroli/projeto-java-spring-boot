package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.mapper.UserMapper;
import com.projetojavaspring.microservice.adpter.dataprovider.repository.UserRepository;
import com.projetojavaspring.microservice.domain.exception.BusinessException;
import com.projetojavaspring.microservice.domain.model.UserDomain;
import com.projetojavaspring.microservice.domain.model.UserRequestDomain;
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
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDomain); //todo: Futuramente refatorar para uma interface -> userGateway
        UserEntity createdUser = this.userRepository.save(userEntity); //todo: Futuramente refatorar para uma interface -> userGateway

        return UserMapper.INSTANCE.toDomain(createdUser);
    }

    private void validateUsername(UserDomain newUser) {
        if (newUser.getUsername().length() < 8) {
            throw new BusinessException("Username must be at least 8 characters");
        }
    }
}
