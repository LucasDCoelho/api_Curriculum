package com.curriculum.api_cadastro_curriculum.domain.model;

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
    private LocalDate dataDeNascimento;
    private String email;
    private int telefone;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    private String funcao;
    @Embedded
    private Competencia competencia;

}
