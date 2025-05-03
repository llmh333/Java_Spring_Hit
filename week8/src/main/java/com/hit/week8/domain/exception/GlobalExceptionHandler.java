package com.hit.week8.domain.exception;

import com.hit.week8.constant.ErrorCode;
import com.hit.week8.response.ApiResponse;
import com.hit.week8.response.ApiResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidateException(MethodArgumentNotValidException ex) {
        return ApiResponseUtil.badRequest(ex.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> handleDuplicateException(DuplicateException ex) {
        return ApiResponseUtil.conflict(ex.getErrorCode());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        return ApiResponseUtil.notFound(ex.getErrorCode());
    }
}
