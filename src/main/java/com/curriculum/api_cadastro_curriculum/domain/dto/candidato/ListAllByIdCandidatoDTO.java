package com.curriculum.api_cadastro_curriculum.domain.dto.candidato;

import com.curriculum.api_cadastro_curriculum.domain.auth.model.User;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;

public record ListAllByIdCandidatoDTO(
        Long userId
) { }
