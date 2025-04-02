package com.hit.week4.exception;

import com.hit.week4.response.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHanlder {



    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<String>> dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        ApiResponse<String> response = new ApiResponse<>(400, dataIntegrityViolationException.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> illegalArgumentException(IllegalArgumentException illegalArgumentException) {
        ApiResponse<String> response = new ApiResponse<>(409, illegalArgumentException.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiResponse<String>> nullPointerException(NullPointerException nullPointerException) {
        ApiResponse<String> response = new ApiResponse<>(404, nullPointerException.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
