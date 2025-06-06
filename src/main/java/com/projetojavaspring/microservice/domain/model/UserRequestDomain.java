package com.projetojavaspring.microservice.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDomain {
  private String username;
  private String email;
  private String password;
}
