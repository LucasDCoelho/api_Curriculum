package com.curriculum.api_cadastro_curriculum.domain.dto.candidato;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import com.curriculum.api_cadastro_curriculum.domain.model.Competencia;

import java.time.LocalDate;
import java.util.Set;

public record DetailsCandidatoDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataDeNascimento,
        String email,
        String telefone,
        Escolaridade escolaridade,
        String funcao,
        Set<Competencia> competencias
) {
    public DetailsCandidatoDTO(Candidato candidato){
        this(
                candidato.getId(),
                candidato.getNome(),
                candidato.getCpf(),
                candidato.getDataDeNascimento(),
                candidato.getEmail(),
                candidato.getTelefone(),
                candidato.getEscolaridade(),
                candidato.getFuncao(),
                candidato.getCompetencias()
        );
    }
}
