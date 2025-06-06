package com.projetojavaspring.microservice.domain.model;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDomain {
  private Long id;
  private Long userId;
  private String content;
  private String imageUrl;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
