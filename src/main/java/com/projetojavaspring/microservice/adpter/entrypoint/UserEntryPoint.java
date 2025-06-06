package com.projetojavaspring.microservice.adpter.entrypoint;

import com.projetojavaspring.microservice.adpter.entrypoint.dto.UserRequestDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.dto.UserResponseDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.mapper.UserEntrypointMapper;
import com.projetojavaspring.microservice.usecase.CreateUserUseCase;
import com.projetojavaspring.microservice.usecase.FindUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserEntryPoint {

  private final CreateUserUseCase createUserUseCase;
  private final FindUserUseCase findUserUseCase;

  @PostMapping
  public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
    var requestDomain = UserEntrypointMapper.INSTANCE.toDomain(userRequestDTO);
    var userDomain = createUserUseCase.execute(requestDomain);
    return UserEntrypointMapper.INSTANCE.toDTO(userDomain);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponseDTO> findUser(@PathVariable Long userId) {
    var userDomain = findUserUseCase.execute(userId);
    System.out.println("✅ UserDomain: " + userDomain);
    System.out.println("📝 Posts no dominio: " + userDomain.getPosts().size());

    var userResponse = UserEntrypointMapper.INSTANCE.toDTO(userDomain);
    System.out.println("🎯 UserResponseDTO: " + userResponse);
    return ResponseEntity.ok(userResponse);
  }
}
