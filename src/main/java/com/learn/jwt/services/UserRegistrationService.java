package com.learn.jwt.services;

import com.learn.jwt.entity.UserEntity;
import com.learn.jwt.model.UserRegistrationRequest;
import com.learn.jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {
    private final UserRepository userRepository;

    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
        UserEntity userEntity = UserEntity.builder()
                .username(userRegistrationRequest.username())
                .password(userRegistrationRequest.password())
                .email(userRegistrationRequest.email())
                .build();
        userRepository.saveAndFlush(userEntity);
    }

}
