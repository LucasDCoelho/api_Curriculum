package com.curriculum.api_cadastro_curriculum.repository;

import com.curriculum.api_cadastro_curriculum.domain.model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRespository extends JpaRepository<Adm, Long> {
}
