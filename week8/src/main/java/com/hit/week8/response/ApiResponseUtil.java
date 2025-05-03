package com.hit.week8.response;

import com.hit.week8.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {

    public static ResponseEntity<?> success(Object data) {
        return success(HttpStatus.OK,data);
    }

    public static ResponseEntity<?> success(HttpStatus status) {
        return success(status,null);
    }

    public static ResponseEntity<?> success(HttpStatus status, Object data) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(status.value())
                .success(true)
                .status(status)
                .data(data)
                .build();
        return new ResponseEntity<>(apiResponse, status);
    }

    public static ResponseEntity<?> notFound(ErrorCode errorCode) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND)
                .success(false)
                .message(errorCode.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    public static ResponseEntity<?> badRequest(ErrorCode errorCode) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .success(false)
                .data(errorCode)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    public static ResponseEntity<?> badRequest(String message) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .success(false)
                .message(message)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    public static ResponseEntity<?> conflict(ErrorCode errorCode) {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .status(HttpStatus.CONFLICT)
                .success(false)
                .data(errorCode)
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }
}
