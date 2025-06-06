package com.projetojavaspring.microservice.domain.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  public BusinessException(String message) {
    super(message);
  }
}
