package com.hit.week9.controller;

import com.hit.week9.base.RestApiV1;
import com.hit.week9.constant.ErrorMessage;
import com.hit.week9.domain.dto.request.AuthenticationRequest;
import com.hit.week9.domain.dto.request.CreateUserRequest;
import com.hit.week9.domain.dto.response.AuthenticationResponseDTO;
import com.hit.week9.domain.dto.response.UserResponseDTO;
import com.hit.week9.service.AuthenticationService;
import com.hit.week9.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestApiV1
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.login(authenticationRequest);
        if (authenticationResponseDTO.isAuthenticated()) {
            return ApiResponseUtil.success(authenticationResponseDTO, HttpStatus.OK);
        }
        return ApiResponseUtil.error(HttpStatus.UNAUTHORIZED, ErrorMessage.Authentication.AUTHENTICATION_FAILED);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserResponseDTO userResponseDTO = authenticationService.register(createUserRequest);
        if (userResponseDTO == null) {
            return ApiResponseUtil.error(HttpStatus.BAD_REQUEST);
        }
        return ApiResponseUtil.success(userResponseDTO, HttpStatus.CREATED);
    }
}
