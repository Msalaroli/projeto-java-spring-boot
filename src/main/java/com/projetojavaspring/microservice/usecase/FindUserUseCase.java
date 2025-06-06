package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.jpa.PostRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.UserRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.entity.UserEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.mapper.UserMapper;
import com.projetojavaspring.microservice.domain.UserDomain;
import com.projetojavaspring.microservice.usecase.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserUseCase {

  private final UserRepository userRepository;
  private final PostRepository postRepository;

  public UserDomain execute(Long userId) {
    UserEntity userEntity =
        userRepository.findById(userId).orElseThrow(() -> new BusinessException("User not found"));

    System.out.println("Posts size: " + userEntity.getPosts().size());
    return UserMapper.INSTANCE.toDomain(userEntity);
  }
}
