package com.projetojavaspring.microservice.domain.model;

import lombok.Data;

@Data
public class UserRequestDomain {
    private String username;
    private String email;
    private String password;
}
