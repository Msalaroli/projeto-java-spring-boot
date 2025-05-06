package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO { //todo: refatorar para record
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
