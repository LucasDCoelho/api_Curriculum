package com.curriculum.api_cadastro_curriculum.repository.auth;

import com.curriculum.api_cadastro_curriculum.domain.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
