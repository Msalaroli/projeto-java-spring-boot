package com.projetojavaspring.microservice.adpter.entrypoint.mapper;

import com.projetojavaspring.microservice.adpter.entrypoint.dto.UserRequestDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.dto.UserResponseDTO;
import com.projetojavaspring.microservice.domain.model.UserDomain;
import com.projetojavaspring.microservice.domain.model.UserRequestDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntrypointMapper {
    UserEntrypointMapper INSTANCE = Mappers.getMapper(UserEntrypointMapper.class);

    UserRequestDomain toDomain(UserRequestDTO dto);

    UserResponseDTO toDTO(UserDomain domain);
}
