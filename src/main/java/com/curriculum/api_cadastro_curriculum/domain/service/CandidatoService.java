package com.curriculum.api_cadastro_curriculum.domain.service;

import com.curriculum.api_cadastro_curriculum.domain.dto.RegisterCandidato;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import com.curriculum.api_cadastro_curriculum.domain.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public Candidato create(RegisterCandidato data) {
        Candidato candidato = new Candidato(data);

        return candidatoRepository.save(candidato);
    }
}
