package com.projetojavaspring.microservice.adpter.dataprovider.mapper;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.PostEntity;
import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import com.projetojavaspring.microservice.domain.model.PostDomain;
import com.projetojavaspring.microservice.domain.model.UserDomain;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(source = "password", target = "passwordHash")
  UserEntity toEntity(UserDomain domain);

  @Mapping(source = "posts", target = "posts", qualifiedByName = "mapPosts")
  UserDomain toDomain(UserEntity user);

  @Named("mapPosts")
  default Set<PostDomain> mapPosts(Set<PostEntity> posts) {
    return PostMapper.INSTANCE.toDomain(posts);
  }
}
