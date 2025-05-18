package com.hit.week9.controller;

import com.hit.week9.base.RestApiV1;
import com.hit.week9.domain.dto.response.UserResponseDTO;
import com.hit.week9.service.UserService;
import com.hit.week9.util.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestApiV1
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        List<UserResponseDTO> userResponseDTOS = userService.getAllUsers();
        return ApiResponseUtil.success(userResponseDTOS);
    }
}
