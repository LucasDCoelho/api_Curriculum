package com.curriculum.api_cadastro_curriculum.controller;

import com.curriculum.api_cadastro_curriculum.domain.auth.dto.AuthenticationDTO;
import com.curriculum.api_cadastro_curriculum.domain.auth.dto.RegisterDTO;
import com.curriculum.api_cadastro_curriculum.domain.auth.dto.ResponseTokenDTO;
import com.curriculum.api_cadastro_curriculum.service.auth.AuthorizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthorizationService authorizationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<ResponseTokenDTO> login(@RequestBody @Valid AuthenticationDTO data){
        var token = authorizationService.login(data, authenticationManager);
        return ResponseEntity.ok(new ResponseTokenDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        var isRegistered = authorizationService.register(data);
        return  isRegistered ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

}
