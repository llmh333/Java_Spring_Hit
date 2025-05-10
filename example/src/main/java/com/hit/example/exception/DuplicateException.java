package com.hit.example.exception;

import com.hit.example.constant.ErrorCode;

public class DuplicateException extends RuntimeException {
    ErrorCode errorCode;
    public DuplicateException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
