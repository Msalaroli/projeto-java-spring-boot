package com.projetojavaspring.microservice.entrypoint.mapper;

import com.projetojavaspring.microservice.domain.model.UserDomain;
import com.projetojavaspring.microservice.domain.model.UserRequestDomain;
import com.projetojavaspring.microservice.entrypoint.dto.UserRequestDTO;
import com.projetojavaspring.microservice.entrypoint.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntrypointMapper {
    UserEntrypointMapper INSTANCE = Mappers.getMapper(UserEntrypointMapper.class);

    UserRequestDomain toDomain(UserRequestDTO dto);
    UserResponseDTO toDTO(UserDomain domain);
}
