package com.projetojavaspring.microservice.adpter.dataprovider.mapper;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.PostEntity;
import com.projetojavaspring.microservice.domain.model.PostDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostEntity toEntity(PostDomain domain);

    PostDomain toDomain(PostEntity entity);
}
