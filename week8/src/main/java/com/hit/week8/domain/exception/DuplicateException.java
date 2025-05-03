package com.hit.week8.domain.exception;

import com.hit.week8.constant.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException {
    ErrorCode errorCode;
    public DuplicateException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
