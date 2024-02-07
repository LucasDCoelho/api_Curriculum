package com.curriculum.api_cadastro_curriculum.domain.dto;

import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import com.curriculum.api_cadastro_curriculum.domain.model.Competencia;

import java.time.LocalDate;

public record RegisterCandidato(
        String nome,
        int cpf,
        LocalDate dataDeNascimento,
        String email,
        int telefone,
        Escolaridade escolaridade,
        String funcao,
        Competencia competencia
) {
}
