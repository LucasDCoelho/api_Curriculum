package com.curriculum.api_cadastro_curriculum.domain.dto.adm;

import com.curriculum.api_cadastro_curriculum.domain.model.Adm;

public record AdmDetailsDTO(
        String nome,
        String cpf,
        String dataDeNascimento,
        String email,
        String telefone,
        String funcao
) {
    public AdmDetailsDTO(Adm adm) {
        this(
                adm.getNome(),
                adm.getCpf(),
                adm.getDataDeNascimento(),
                adm.getEmail(),
                adm.getTelefone(),
                adm.getFuncao()
        );
    }
}
