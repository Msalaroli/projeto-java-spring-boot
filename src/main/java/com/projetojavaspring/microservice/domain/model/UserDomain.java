package com.projetojavaspring.microservice.domain.model;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain {
  private Long id;
  private String username;
  private String email;
  private String password;
  private String fullName;
  private String bio;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Set<PostDomain> posts;
}
