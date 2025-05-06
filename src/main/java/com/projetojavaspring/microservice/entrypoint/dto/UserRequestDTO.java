package com.projetojavaspring.microservice.entrypoint.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
