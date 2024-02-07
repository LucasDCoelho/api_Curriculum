package com.curriculum.api_cadastro_curriculum.domain.controller;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.service.CandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoService candidatoService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid RegisterCandidatoDTO candidato){
        candidatoService.create(candidato);

        return ResponseEntity.ok(candidato);
    }
}
