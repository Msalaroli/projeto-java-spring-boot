package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import jakarta.validation.constraints.NotNull;

public record PostRequestDTO(@NotNull Long userId, @NotNull String content, String imageUrl) {}
