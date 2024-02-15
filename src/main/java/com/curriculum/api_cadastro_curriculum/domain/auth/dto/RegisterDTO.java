package com.curriculum.api_cadastro_curriculum.domain.auth.dto;

import com.curriculum.api_cadastro_curriculum.domain.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotNull
        UserRole role
) {
}
