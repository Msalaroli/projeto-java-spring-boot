package com.projetojavaspring.microservice.adpter.dataprovider.mapper;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.PostEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import com.projetojavaspring.microservice.domain.model.PostDomain;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
  PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

  PostEntity toEntity(PostDomain domain);

  default PostEntity toEntity(PostDomain domain, UserEntity user) {
    var postEntity = toEntity(domain);
    postEntity.setUser(user);

    return postEntity;
  }

  @Mapping(source = "user.id", target = "userId")
  PostDomain toDomain(PostEntity entity);

  Set<PostDomain> toDomain(Set<PostEntity> domain);
}
