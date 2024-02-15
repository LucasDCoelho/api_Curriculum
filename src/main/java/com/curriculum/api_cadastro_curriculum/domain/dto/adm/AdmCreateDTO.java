package com.curriculum.api_cadastro_curriculum.domain.dto.adm;

import jakarta.persistence.Column;

public record AdmCreateDTO(
        String nome,
        String cpf,
        String dataDeNascimento,
        String email,
        String telefone,
        String funcao
) {

}
