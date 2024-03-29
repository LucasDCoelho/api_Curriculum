package com.curriculum.api_cadastro_curriculum.controller;

import com.curriculum.api_cadastro_curriculum.domain.auth.model.User;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.DetailsCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.ListAllCandidatosDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.UpdateCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.dto.candidato.RegisterCandidatoDTO;
import com.curriculum.api_cadastro_curriculum.domain.model.Candidato;
import com.curriculum.api_cadastro_curriculum.infra.security.TokenService;
import com.curriculum.api_cadastro_curriculum.service.CandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoService candidatoService;
    private final TokenService tokenService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<DetailsCandidatoDTO> createCandidato(
            @RequestBody @Valid RegisterCandidatoDTO data,
            UriComponentsBuilder uriBuilder,
            @RequestHeader(name = "Authorization") String token
            ){
        Long userId = tokenService.getUserIdFromToken(token.substring(7));
        Candidato candidato = candidatoService.create(userId, data);

        var uri = uriBuilder.path("/candidato/{id}").buildAndExpand(candidato.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsCandidatoDTO(candidato));
    }


    @GetMapping("/list-all")
    public ResponseEntity<Page<ListAllCandidatosDTO>> listarAllCandidatos(Pageable pageable){
        Page<ListAllCandidatosDTO> listAllCandidatos = candidatoService.listAll(pageable);

        return ResponseEntity.ok(listAllCandidatos);
    }

    @GetMapping("/list-all-by-id")
    public ResponseEntity<List<Candidato>> getCandidatosDoUsuario(
            @RequestHeader(name = "Authorization") String token
    ) {
        Long userId = tokenService.getUserIdFromToken(token.substring(7));
        List<Candidato> candidatos = candidatoService.getFindByUserId(userId);
        return ResponseEntity.ok(candidatos);
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

    @PostMapping("/{id}/approve")
    @Transactional
    public ResponseEntity<String> approveCandidato(@PathVariable Long id){
        candidatoService.approveCandidato(id);
        return ResponseEntity.ok("Candidato aprovado com sucesso");
    }

    @PostMapping("/{id}/reject")
    @Transactional
    public ResponseEntity<String> rejectCandidato(@PathVariable Long id){
        candidatoService.rejectCandidato(id);
        return ResponseEntity.ok("Candidato reprovado com sucesso");
    }

    @PostMapping("/{id}/reset")
    @Transactional
    public ResponseEntity<String> resetCandidato(@PathVariable Long id){
        candidatoService.resetCandidato(id);
        return ResponseEntity.ok("Candidato resetado com sucesso");
    }
}
