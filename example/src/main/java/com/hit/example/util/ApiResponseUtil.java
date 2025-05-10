package com.hit.example.util;

import com.hit.example.constant.ErrorCode;
import com.hit.example.constant.StatusReponse;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
public class ApiResponseUtil {
    public static ResponseEntity<?> success(Object data, HttpStatus status) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(status.value())
                .status(status)
                .data(data)
                .timestamp(LocalDateTime.now())
                .message(StatusReponse.SUCCESS.name())
                .build();
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

    public static ResponseEntity<?> error(ErrorCode errorCode) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(errorCode.getHttpStatus().value())
                .status(errorCode.getHttpStatus())
                .message(errorCode.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }
}
