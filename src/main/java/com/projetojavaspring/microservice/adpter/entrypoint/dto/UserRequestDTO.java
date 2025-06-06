package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
    @NotNull String username, @NotNull String email, @NotNull String password) {}
