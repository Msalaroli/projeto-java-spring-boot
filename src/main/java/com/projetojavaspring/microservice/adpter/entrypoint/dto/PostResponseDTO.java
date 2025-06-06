package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import java.time.LocalDateTime;

public record PostResponseDTO(
    Long id, Long userId, String content, String imageUrl, LocalDateTime createdAt) {}
