package com.curriculum.api_cadastro_curriculum.repository;

import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Page<Candidato> findByAtivoTrue(Pageable pageable);
}
