package com.curriculum.api_cadastro_curriculum.domain.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
