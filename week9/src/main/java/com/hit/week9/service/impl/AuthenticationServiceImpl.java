package com.hit.week9.service.impl;

import com.hit.week9.domain.dto.request.AuthenticationRequest;
import com.hit.week9.domain.dto.request.CreateUserRequest;
import com.hit.week9.domain.dto.response.AuthenticationResponseDTO;
import com.hit.week9.domain.dto.response.UserResponseDTO;
import com.hit.week9.domain.entity.User;
import com.hit.week9.domain.mapper.UserMapper;
import com.hit.week9.repository.UserRepository;
import com.hit.week9.service.AuthenticationService;
import com.hit.week9.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public AuthenticationResponseDTO login(AuthenticationRequest authenticationRequest) {
        AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO();
        authenticationResponseDTO.setAuthenticated(false);
        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        if (user != null) {
            boolean matches = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
            if (matches) {
                authenticationResponseDTO.setUsername(user.getUsername());
                authenticationResponseDTO.setId(user.getId());
                authenticationResponseDTO.setAuthenticated(true);
            }
        }
        return authenticationResponseDTO;
    }

    @Override
    public UserResponseDTO register(CreateUserRequest createUserRequest) {
        UserResponseDTO userResponseDTO = userService.createNewUser(createUserRequest);
        return userResponseDTO;
    }
}
