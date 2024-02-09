package com.curriculum.api_cadastro_curriculum.domain.model;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Proficiencia;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "competencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Competencia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Proficiencia proficiencia;


    public Competencia(CompetenciaDTO data) {
        this.descricao = data.descricao();
        this.proficiencia = data.proficiencia();
    }
}
