package com.curriculum.api_cadastro_curriculum.domain.service;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.DetailsCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.ListAllCandidatosDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.UpdateCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.competencia.CompetenciaDTO;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import com.curriculum.api_cadastro_curriculum.domain.model.Competencia;
import com.curriculum.api_cadastro_curriculum.domain.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public Candidato create(RegisterCandidatoDTO data) {
        Candidato candidato = new Candidato(data);

        return candidatoRepository.save(candidato);
    }


    public Page<ListAllCandidatosDTO> listAll(Pageable pageable) {
        return candidatoRepository.findByAtivoTrue(pageable).map(ListAllCandidatosDTO::new);
    }

    public Candidato update(UpdateCandidatoDTO data) {
        Candidato candidato = candidatoRepository.getReferenceById(data.id());

        if (data.nome() != null){
            candidato.setNome(data.nome());
        }
        if (data.cpf() != null){
            candidato.setCpf(data.cpf());
        }
        if (data.dataDeNascimento() != null){
            candidato.setDataDeNascimento(data.dataDeNascimento());
        }
        if (data.email() != null){
            candidato.setEmail(data.email());
        }
        if (data.telefone() != null){
            candidato.setTelefone(data.telefone());
        }
        if (data.escolaridade() != null){
            candidato.setEscolaridade(data.escolaridade());
        }
        if (data.funcao() != null){
            candidato.setFuncao(data.funcao());
        }
        if (data.competencias() != null){
            Set<Competencia> competencias = new HashSet<>();
            for (CompetenciaDTO competenciaDTO : data.competencias()) {
                Competencia competencia = new Competencia(competenciaDTO);
                competencias.add(competencia);
            }
            candidato.setCompetencias(competencias);
        }

        return candidatoRepository.save(candidato);
    }

    public void delete(Long id) {
        Candidato candidato = candidatoRepository.getReferenceById(id);
        candidato.setAtivo(false);
    }

    public DetailsCandidatoDTO details(Long id) {
        Candidato candidato = candidatoRepository.getReferenceById(id);
        return new DetailsCandidatoDTO(candidato);
    }
}
