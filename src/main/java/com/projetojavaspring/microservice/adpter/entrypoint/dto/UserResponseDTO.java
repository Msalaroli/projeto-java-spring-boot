package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String fullName,
        String bio,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

