package com.projetojavaspring.microservice.mapper;

import com.projetojavaspring.microservice.domain.model.UserDomain;
import com.projetojavaspring.microservice.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "password", target = "passwordHash")
    UserEntity toEntity(UserDomain domain);

    UserDomain toDomain(UserEntity user);
}

