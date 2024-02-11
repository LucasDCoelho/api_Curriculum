package com.curriculum.api_cadastro_curriculum.service;

import com.curriculum.api_cadastro_curriculum.domain.dto.adm.AdmCreateDTO;
import com.curriculum.api_cadastro_curriculum.domain.model.Adm;
import com.curriculum.api_cadastro_curriculum.repository.AdmRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmService {

    private final AdmRespository admRespository;

    public Adm create(AdmCreateDTO admCreateDTO) {
        Adm adm = new Adm(admCreateDTO);

       return admRespository.save(adm);
    }
}
