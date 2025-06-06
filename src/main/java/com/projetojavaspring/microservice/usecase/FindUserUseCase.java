package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.mapper.UserMapper;
import com.projetojavaspring.microservice.adpter.dataprovider.repository.PostRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.repository.UserRepository;
import com.projetojavaspring.microservice.domain.exception.BusinessException;
import com.projetojavaspring.microservice.domain.model.UserDomain;
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
