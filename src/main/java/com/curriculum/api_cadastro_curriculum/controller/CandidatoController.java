package com.curriculum.api_cadastro_curriculum.controller;

import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.DetailsCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.ListAllCandidatosDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.UpdateCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import com.curriculum.api_cadastro_curriculum.service.CandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoService candidatoService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<DetailsCandidatoDTO> createCandidato(@RequestBody @Valid RegisterCandidatoDTO data, UriComponentsBuilder uriBuilder){
        Candidato candidato = candidatoService.create(data);

        var uri = uriBuilder.path("/candidato/{id}").buildAndExpand(candidato.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsCandidatoDTO(candidato));
    }


    @GetMapping("/list-all")
    public ResponseEntity<Page<ListAllCandidatosDTO>> listarAllCandidatos(Pageable pageable){
        Page<ListAllCandidatosDTO> listAllCandidatos = candidatoService.listAll(pageable);

        return ResponseEntity.ok(listAllCandidatos);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<DetailsCandidatoDTO> updateCandidato(@RequestBody @Valid UpdateCandidatoDTO data){
        Candidato candidato = candidatoService.update(data);
        return ResponseEntity.ok(new DetailsCandidatoDTO(candidato));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity deleteCandidato(@PathVariable Long id){
        candidatoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsCandidatoDTO> detailsCandidato(@PathVariable Long id){
        DetailsCandidatoDTO detailCandidato = candidatoService.details(id);
        return ResponseEntity.ok(detailCandidato);
    }
}
