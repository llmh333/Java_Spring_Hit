package com.hit.week8.domain.service.impl;

import com.hit.week8.mapper.UserMapper;
import com.hit.week8.domain.dto.repsonse.UserResponseDTO;
import com.hit.week8.domain.dto.request.CreateUserRequest;
import com.hit.week8.domain.dto.request.UpdateUserRequest;
import com.hit.week8.domain.entity.User;
import com.hit.week8.constant.ErrorCode;
import com.hit.week8.domain.exception.DuplicateException;
import com.hit.week8.domain.exception.NotFoundException;
import com.hit.week8.domain.repository.UserRepository;
import com.hit.week8.domain.service.UserService;
import com.hit.week8.util.EncryptionPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
            userResponseDTOS.add(userMapper.toUserResponseDTO(user));
        }
        return userResponseDTOS;
    }

    @Override
    public UserResponseDTO addUser(CreateUserRequest createUserRequest) {
        System.out.println(createUserRequest);
        if (userRepository.existsUserByUsername(createUserRequest.getUsername())) {
            throw new DuplicateException(ErrorCode.USERNAME_EXIST);
        } else if (userRepository.existsUserByEmail(createUserRequest.getEmail())) {
            throw new DuplicateException(ErrorCode.EMAIL_EXIST);
        }
        createUserRequest.setPassword(EncryptionPassword.encryptPassword(createUserRequest.getPassword()));
        User savedUser = userRepository.save(userMapper.toUser(createUserRequest));
        System.out.println(savedUser);
        return userMapper.toUserResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO updateUser(String id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND));
        if (updateUserRequest.getEmail() != null) {
            user.setEmail(updateUserRequest.getEmail());
        }
        if (updateUserRequest.getPassword() != null) {
            user.setPassword(updateUserRequest.getPassword());
        }
        user.setCreatedAt(LocalDateTime.now());
        return userMapper.toUserResponseDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

}
