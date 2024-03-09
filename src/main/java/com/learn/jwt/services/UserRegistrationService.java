package com.learn.jwt.services;

import com.learn.jwt.entity.UserEntity;
import com.learn.jwt.model.UserRegistrationRequest;
import com.learn.jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
@AllArgsConstructor
@Slf4j
public class UserRegistrationService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userRegistrationRequest.password());
        UserEntity userEntity = UserEntity.builder()
                .username(userRegistrationRequest.username())
                .password(encodedPassword)
                .email(userRegistrationRequest.email())
                .build();
        userRepository.saveAndFlush(userEntity);
        log.info("User registered: {}", userEntity);
    }

}
