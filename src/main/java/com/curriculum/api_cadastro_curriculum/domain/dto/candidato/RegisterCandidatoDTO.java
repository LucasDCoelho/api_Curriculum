package com.curriculum.api_cadastro_curriculum.domain.dto.candidato;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterCandidatoDTO(
        @NotBlank
        String nome,
        @NotBlank
        int cpf,
        @NotBlank
        LocalDate dataDeNascimento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        int telefone,
        @NotNull
        Escolaridade escolaridade,
        @NotBlank
        String funcao,
        @NotNull
        @Valid
        CompetenciaDTO competencia
) {
}
