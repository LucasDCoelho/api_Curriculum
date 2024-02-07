package com.curriculum.api_cadastro_curriculum.domain.model;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Proficiencia;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Competencia {
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Proficiencia proficiencia;

    public Competencia(CompetenciaDTO data) {
        this.descricao = data.descricao();
        this.proficiencia = data.proficiencia();
    }
}
