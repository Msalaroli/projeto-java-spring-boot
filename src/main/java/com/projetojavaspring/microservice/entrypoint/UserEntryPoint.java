package com.projetojavaspring.microservice.entrypoint;

import com.projetojavaspring.microservice.domain.usecase.CreateUserUseCase;
import com.projetojavaspring.microservice.entrypoint.dto.UserRequestDTO;
import com.projetojavaspring.microservice.entrypoint.dto.UserResponseDTO;
import com.projetojavaspring.microservice.entrypoint.mapper.UserEntrypointMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserEntryPoint {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        var requestDomain = UserEntrypointMapper.INSTANCE.toDomain(userRequestDTO);
        var userDomain = createUserUseCase.execute(requestDomain);
        return UserEntrypointMapper.INSTANCE.toDTO(userDomain);
    }
}
