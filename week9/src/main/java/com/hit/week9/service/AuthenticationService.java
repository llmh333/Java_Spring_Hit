package com.hit.week9.service;

import com.hit.week9.domain.dto.request.AuthenticationRequest;
import com.hit.week9.domain.dto.request.CreateUserRequest;
import com.hit.week9.domain.dto.response.AuthenticationResponseDTO;
import com.hit.week9.domain.dto.response.UserResponseDTO;

public interface AuthenticationService {

    public AuthenticationResponseDTO login(AuthenticationRequest authenticationRequest);
    public UserResponseDTO register(CreateUserRequest createUserRequest);
}
