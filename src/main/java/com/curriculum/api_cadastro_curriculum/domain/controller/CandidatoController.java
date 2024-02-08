package com.curriculum.api_cadastro_curriculum.domain.controller;

import com.curriculum.api_cadastro_curriculum.domain.dto.ListAllCandidatosDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.service.CandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoService candidatoService;

    @PostMapping
    @Transactional
    public ResponseEntity createCandidato(@RequestBody @Valid RegisterCandidatoDTO candidato){
        candidatoService.create(candidato);

        return ResponseEntity.ok(candidato);
    }


    @GetMapping
    public ResponseEntity<Page<ListAllCandidatosDTO>> listarAllCandidatos(Pageable pageable){
        Page<ListAllCandidatosDTO> listAllCandidatos = candidatoService.listAll(pageable);

        return ResponseEntity.ok(listAllCandidatos);
    }
}
