package com.curriculum.api_cadastro_curriculum.domain.dto.candidato;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

public record UpdateCandidatoDTO(
        @NotNull
        Long id,
        String nome,
        String cpf,
        LocalDate dataDeNascimento,
        String email,
        String telefone,
        Escolaridade escolaridade,
        String funcao,
        Set<CompetenciaDTO> competencias
) {
}
