package com.hit.week9.service;

import com.hit.week9.domain.dto.request.CreateUserRequest;
import com.hit.week9.domain.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    public List<UserResponseDTO> getAllUsers();
    public UserResponseDTO createNewUser(CreateUserRequest createUserRequest);
}
