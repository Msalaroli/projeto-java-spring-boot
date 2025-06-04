package com.projetojavaspring.microservice.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserDomain {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<PostDomain> posts;
}
