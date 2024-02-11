package com.curriculum.api_cadastro_curriculum.controller;

import com.curriculum.api_cadastro_curriculum.domain.dto.adm.AdmCreateDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.adm.AdmDetailsDTO;
import com.curriculum.api_cadastro_curriculum.domain.model.Adm;
import com.curriculum.api_cadastro_curriculum.service.AdmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adm")
@RequiredArgsConstructor
public class AdmController {

    private final AdmService admService;

    @PostMapping
    public ResponseEntity<AdmDetailsDTO> createAdm(@RequestBody @Valid AdmCreateDTO admCreateDTO){
        Adm adm = admService.create(admCreateDTO);

        return ResponseEntity.ok(new AdmDetailsDTO(adm));
    }
}
