package com.curriculum.api_cadastro_curriculum.domain.model;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Candidato")
@Table(name = "candidato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Candidato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Column(name = "datadenascimento")
    private LocalDate dataDeNascimento;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    private String funcao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidato_id")
    private Set<Competencia> competencias;

    private boolean ativo;
    private String situacao;

    public Candidato(RegisterCandidatoDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dataDeNascimento = data.dataDeNascimento();
        this.email = data.email();
        this.telefone = data.telefone();
        this.escolaridade = data.escolaridade();
        this.funcao = data.funcao();
        if (data.competencias() != null) {
            data.competencias().forEach(competenciaDTO -> this.competencias.add(new Competencia(competenciaDTO)));
        }
        this.ativo = true;
        this.situacao = "AGUARDANDO";
    }
}
