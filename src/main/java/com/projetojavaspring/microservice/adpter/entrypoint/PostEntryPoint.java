package com.projetojavaspring.microservice.adpter.entrypoint;

import com.projetojavaspring.microservice.adpter.entrypoint.dto.PostRequestDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.dto.PostResponseDTO;
import com.projetojavaspring.microservice.adpter.entrypoint.mapper.PostEntrypointMapper;
import com.projetojavaspring.microservice.usecase.CreatePostUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostEntryPoint {
    private final CreatePostUseCase createPostUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDTO createPost(@RequestBody @Valid PostRequestDTO postRequestDTO){
        var requestDomain = PostEntrypointMapper.INSTANCE.toDomain(postRequestDTO);
        var postDomain = createPostUseCase.execute(requestDomain);
        return PostEntrypointMapper.INSTANCE.toDTO(postDomain);
    }
}
