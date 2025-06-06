package com.projetojavaspring.microservice.domain;

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
