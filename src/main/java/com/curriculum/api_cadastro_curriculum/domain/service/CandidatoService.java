package com.curriculum.api_cadastro_curriculum.domain.service;

import com.curriculum.api_cadastro_curriculum.domain.dto.ListAllCandidatosDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import com.curriculum.api_cadastro_curriculum.domain.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
