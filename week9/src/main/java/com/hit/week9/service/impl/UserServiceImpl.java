package com.hit.week9.service.impl;

import com.hit.week9.constant.ErrorMessage;
import com.hit.week9.domain.dto.request.CreateUserRequest;
import com.hit.week9.domain.dto.response.UserResponseDTO;
import com.hit.week9.domain.entity.User;
import com.hit.week9.domain.mapper.UserMapper;
import com.hit.week9.exception.ResourceAlreadyExistsException;
import com.hit.week9.exception.ResourceNotFoundException;
import com.hit.week9.repository.UserRepository;
import com.hit.week9.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException(ErrorMessage.User.USER_NOT_FOUND_ERROR);
        }
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        for (User user : users) {
            userResponseDTOs.add(userMapper.toUserResponseDTO(user));
        }
        return userResponseDTOs;
    }

    @Override
    public UserResponseDTO createNewUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsUserByUsername(createUserRequest.getUsername())) {
            throw new ResourceAlreadyExistsException(ErrorMessage.User.USERNAME_ALREADY_EXISTS);
        }
        User newUser = userMapper.toUSer(createUserRequest);
        newUser.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        return userMapper.toUserResponseDTO(userRepository.save(newUser));
    }
}
