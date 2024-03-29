package com.curriculum.api_cadastro_curriculum.domain.dto.candidato;

import com.curriculum.api_cadastro_curriculum.domain.enums.Situacao;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;

public record ListAllCandidatosDTO(
    Long id,
    String nome,
    String cpf,
    String email,
    String telefone,
    Situacao situacao
) {
    public ListAllCandidatosDTO(Candidato candidato){
        this(
                candidato.getId(),
                candidato.getNome(),
                candidato.getCpf(),
                candidato.getEmail(),
                candidato.getTelefone(),
                candidato.getSituacao()
        );

    }

}
