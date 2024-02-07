package com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia;

import com.curriculum.api_cadastro_curriculum.domain.enums.Proficiencia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompetenciaDTO(
    @NotBlank
    String descricao,
    @NotNull
    Proficiencia proficiencia
) {
}
