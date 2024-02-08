package com.curriculum.api_cadastro_curriculum.domain.model;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Proficiencia;
import jakarta.persistence.*;
import lombok.*;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    public Competencia(CompetenciaDTO data, Candidato candidato) {
        this.descricao = data.descricao();
        this.proficiencia = data.proficiencia();
        this.candidato = candidato;
    }
}
