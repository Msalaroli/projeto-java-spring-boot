package com.projetojavaspring.microservice.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDomain {
  private Long userId;
  private String content;
  private String imageUrl;
}
