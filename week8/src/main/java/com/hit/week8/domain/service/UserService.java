package com.hit.week8.domain.service;

import com.hit.week8.domain.dto.repsonse.UserResponseDTO;
import com.hit.week8.domain.dto.request.CreateUserRequest;
import com.hit.week8.domain.dto.request.UpdateUserRequest;
import com.hit.week8.domain.entity.Employee;
import com.hit.week8.domain.entity.User;

import java.util.List;

public interface UserService {

    public UserResponseDTO addUser(CreateUserRequest createUserRequest);

    public List<UserResponseDTO> getAllUsers();

    public UserResponseDTO updateUser(String id, UpdateUserRequest updateUserRequest);

    public void deleteUser(String id);
}
