package com.hit.week9.util;


import com.hit.week9.constant.StatusApi;
import com.hit.week9.domain.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ApiResponseUtil {

    public static ResponseEntity<?> success(Object data) {
        return success(data, HttpStatus.OK);
    }

    public static ResponseEntity<?> success(Object data, HttpStatus status) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(status.value())
                .status(status)
                .message(StatusApi.SUCCESS.name())
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, status);
    }

    public static ResponseEntity<?> error(HttpStatus status, String message) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(status.value())
                .status(status)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, status);
    }

    public static ResponseEntity<?> error(HttpStatus status) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(status.value())
                .status(status)
                .message(StatusApi.ERROR.name())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, status);
    }
}
