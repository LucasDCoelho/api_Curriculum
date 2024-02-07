package com.curriculum.api_cadastro_curriculum.domain.model;

import com.curriculum.api_cadastro_curriculum.domain.dto.RegisterCandidato;
import com.curriculum.api_cadastro_curriculum.domain.enums.Escolaridade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity(name = "Candidato")
@Table(name = "candidato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Candidato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int cpf;
    @Column(name = "data_de_nascimento")
    private LocalDate dataDeNascimento;
    private String email;
    private int telefone;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    private String funcao;
    @Embedded
    private Competencia competencia;

    private boolean ativo;
    private boolean admin;

    public Candidato(RegisterCandidato data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dataDeNascimento = data.dataDeNascimento();
        this.email = data.email();
        this.telefone = data.telefone();
        this.escolaridade = data.escolaridade();
        this.funcao = data.funcao();
        this.competencia = data.competencia();
        this.ativo = true;
        this.admin = false;
    }
}
