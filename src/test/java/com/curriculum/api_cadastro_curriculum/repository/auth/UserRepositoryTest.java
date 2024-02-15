package com.curriculum.api_cadastro_curriculum.repository.auth;

import com.curriculum.api_cadastro_curriculum.domain.auth.model.User;
import com.curriculum.api_cadastro_curriculum.repository.auth.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByLogin() {
        String login = "dev@gmail.com";
        User user = userRepository.findByLogin(login);
        System.out.println("User found: " + user);
    }
}