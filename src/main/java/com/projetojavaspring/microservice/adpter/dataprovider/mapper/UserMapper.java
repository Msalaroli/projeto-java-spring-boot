package com.projetojavaspring.microservice.adpter.dataprovider.mapper;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import com.projetojavaspring.microservice.domain.model.UserDomain;
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

