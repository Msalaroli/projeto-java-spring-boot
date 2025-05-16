package com.projetojavaspring.microservice.adpter.entrypoint.dto;

import java.util.List;

public record ProblemDTO(String message, List<ErrorDTO> errors) {
}
