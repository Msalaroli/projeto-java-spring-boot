package com.projetojavaspring.microservice.domain.model;

import lombok.Data;

@Data
public class PostRequestDomain {
    private Long userId;
    private String content;
    private String imageUrl;
}
