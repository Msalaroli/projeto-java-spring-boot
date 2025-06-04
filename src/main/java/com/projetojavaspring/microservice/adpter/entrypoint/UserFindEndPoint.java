package com.projetojavaspring.microservice.adpter.entrypoint;

import com.projetojavaspring.microservice.adpter.entrypoint.dto.UserResponseDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.mapper.UserEntrypointMapper;
import com.projetojavaspring.microservice.usecase.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserFindEndPoint {
    private final FindUserUseCase findUserUseCase;
    private final UserEntrypointMapper userEntrypointMapper;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable Long userId) {
        var userDomain = findUserUseCase.execute(userId);
        System.out.println("✅ UserDomain: " + userDomain);
        System.out.println("📝 Posts no dominio: " + userDomain.getPosts().size());

        var userResponse = userEntrypointMapper.toDTO(userDomain);
        System.out.println("🎯 UserResponseDTO: " + userResponse);
        return ResponseEntity.ok(userResponse);
    }
}
