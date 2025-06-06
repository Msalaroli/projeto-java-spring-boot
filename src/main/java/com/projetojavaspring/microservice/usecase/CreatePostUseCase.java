package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.jpa.PostRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.UserRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.jpa.mapper.PostMapper;
import com.projetojavaspring.microservice.domain.PostDomain;
import com.projetojavaspring.microservice.domain.PostRequestDomain;
import com.projetojavaspring.microservice.usecase.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostUseCase {

  private final UserRepository userRepository;
  private final PostRepository postRepository;

  public PostDomain execute(PostRequestDomain requestDomain) {

    PostDomain postDomain =
        PostDomain.builder()
            .userId(requestDomain.getUserId())
            .content(requestDomain.getContent())
            .imageUrl(requestDomain.getImageUrl())
            .build();

    validatePost(postDomain);

    var userEntity =
        userRepository
            .findById(requestDomain.getUserId())
            .orElseThrow(() -> new BusinessException("User not found"));

    var postEntity = PostMapper.INSTANCE.toEntity(postDomain, userEntity);

    postRepository.save(postEntity);

    return PostMapper.INSTANCE.toDomain(postEntity);
  }

  private void validatePost(PostDomain postDomain) {
    if (postDomain.getContent() == null) {
      throw new BusinessException("Post content is required");
    }
  }
}
