package com.curriculum.api_cadastro_curriculum.domain.repository;

import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}