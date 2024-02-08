package com.curriculum.api_cadastro_curriculum.domain.dto.candidato;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;



public record RegisterCandidatoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotNull
        LocalDate dataDeNascimento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Escolaridade escolaridade,
        @NotBlank
        String funcao,
        @NotNull
        @Valid
        Set<CompetenciaDTO> competencias
) {
}
