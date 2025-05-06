package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO { //todo: refatorar para record
    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
