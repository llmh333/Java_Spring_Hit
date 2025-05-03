package com.hit.week8.controller;

import com.hit.week8.domain.dto.repsonse.UserResponseDTO;
import com.hit.week8.domain.dto.request.CreateUserRequest;
import com.hit.week8.domain.dto.request.UpdateUserRequest;
import com.hit.week8.domain.service.UserService;
import com.hit.week8.response.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ApiResponseUtil.success(HttpStatus.OK,users);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody @Valid CreateUserRequest request) {
        UserResponseDTO userResponseDTO = userService.addUser(request);
        return ApiResponseUtil.success(HttpStatus.CREATED,userResponseDTO);
    }

    @PatchMapping("/update/{userID}")
    public ResponseEntity<?> updateUser(@PathVariable String userID, @RequestBody @Valid UpdateUserRequest updateUserRequest) {
        UserResponseDTO user = userService.updateUser(userID, updateUserRequest);
        return ApiResponseUtil.success(HttpStatus.OK,user);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
        return ApiResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
