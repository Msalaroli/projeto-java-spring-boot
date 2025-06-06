package com.projetojavaspring.microservice.adpter.entrypoint.mapper;

import com.projetojavaspring.microservice.adpter.entrypoint.dto.PostRequestDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.dto.PostResponseDTO;
import com.projetojavaspring.microservice.domain.model.PostDomain;
import com.projetojavaspring.microservice.domain.model.PostRequestDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostEntrypointMapper {
  PostEntrypointMapper INSTANCE = Mappers.getMapper(PostEntrypointMapper.class);

  PostRequestDomain toDomain(PostRequestDTO dto);

  PostResponseDTO toDTO(PostDomain domain);
}
