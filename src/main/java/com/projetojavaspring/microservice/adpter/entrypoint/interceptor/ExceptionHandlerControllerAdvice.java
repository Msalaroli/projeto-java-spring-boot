package com.projetojavaspring.microservice.adpter.entrypoint.interceptor;

import com.projetojavaspring.microservice.adpter.entrypoint.dto.ProblemDTO;
import com.projetojavaspring.microservice.domain.exception.BusinessException;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ProblemDTO> handleBusinessException(BusinessException ex) {
    ProblemDTO problem = new ProblemDTO(ex.getMessage(), Collections.emptyList());
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(problem);
  }
}
