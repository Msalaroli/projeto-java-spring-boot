package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.mapper.PostMapper;
import com.projetojavaspring.microservice.adpter.dataprovider.repository.PostRepository;
import com.projetojavaspring.microservice.adpter.dataprovider.repository.UserRepository;
import com.projetojavaspring.microservice.domain.exception.BusinessException;
import com.projetojavaspring.microservice.domain.model.PostDomain;
import com.projetojavaspring.microservice.domain.model.PostRequestDomain;
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
