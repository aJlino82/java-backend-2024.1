package com.posback.api.model.dtos;

import lombok.Builder;

@Builder
public record ErrorDTO(String error, String detalhes) {
}
