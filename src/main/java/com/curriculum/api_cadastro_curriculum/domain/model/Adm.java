package com.curriculum.api_cadastro_curriculum.domain.model;

import com.curriculum.api_cadastro_curriculum.domain.dto.adm.AdmCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Adm")
@Table(name = "adm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Adm {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @Column(name = "datadenascimento")
    private String dataDeNascimento;

    private String email;
    private String telefone;
    private String funcao;
    private boolean ativo;

    public Adm(AdmCreateDTO admCreateDTO) {
        this.nome = admCreateDTO.nome();
        this.cpf = admCreateDTO.cpf();
        this.dataDeNascimento = admCreateDTO.dataDeNascimento();
        this.email = admCreateDTO.email();
        this.telefone = admCreateDTO.telefone();
        this.funcao = admCreateDTO.funcao();
        this.ativo = true;
    }
}
