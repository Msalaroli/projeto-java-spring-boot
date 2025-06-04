package com.projetojavaspring.microservice.usecase;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.PostEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.mapper.PostMapper;
import com.projetojavaspring.microservice.adpter.dataprovider.repository.PostRepository;
import com.projetojavaspring.microservice.domain.model.PostDomain;
import com.projetojavaspring.microservice.domain.exception.BusinessException;
import com.projetojavaspring.microservice.domain.model.PostRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostUseCase {
    private final PostRepository postRepository;

    public PostDomain execute(PostRequestDomain requestDomain) {
        PostDomain postDomain = PostDomain.builder()
                .userId(requestDomain.getUserId())
                .content(requestDomain.getContent())
                .imageUrl(requestDomain.getImageUrl())
                .build();

        validatePost(postDomain);
        PostEntity postEntity = PostMapper.INSTANCE.toEntity(postDomain);
        PostEntity createdPost = this.postRepository.save(postEntity);

        return PostMapper.INSTANCE.toDomain(createdPost);
    }

    private void validatePost(PostDomain postDomain) {
        if (postDomain.getContent() == null) {
            throw new BusinessException("Post content is required");
        }
        if(postDomain.getUserId() == null){
            throw new BusinessException("User not found");
        }
    }
}
