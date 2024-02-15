package com.curriculum.api_cadastro_curriculum.service.auth;

import com.curriculum.api_cadastro_curriculum.domain.auth.dto.AuthenticationDTO;
import com.curriculum.api_cadastro_curriculum.domain.auth.dto.RegisterDTO;
import com.curriculum.api_cadastro_curriculum.domain.auth.model.User;
import com.curriculum.api_cadastro_curriculum.infra.security.TokenService;
import com.curriculum.api_cadastro_curriculum.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


// Service para o spring security consultar na tabela no db, o login do usuario;
@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public String login(AuthenticationDTO data, AuthenticationManager authenticationManager) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public boolean register(RegisterDTO data) {
        if(this.userRepository.findByLogin(data.login()) != null) return false;
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.userRepository.save(newUser);
        return true;
    }
}
