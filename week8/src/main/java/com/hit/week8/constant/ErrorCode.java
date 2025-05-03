package com.hit.week8.constant;

import lombok.Getter;


@Getter
public enum ErrorCode {

    EMAIL_EXIST("email", ErrorMessage.EMAIL_ALREADY_EXISTS),
    USERNAME_EXIST("username", ErrorMessage.USERNAME_ALREADY_EXISTS),
    USER_NOT_FOUND("user", ErrorMessage.USER_NOT_FOUND),

    DEPARTMENT_NAME_EXIST("departmentName", ErrorMessage.DEPARTMENT_NAME_EXIST),
    DEPARTMENT_NOT_FOUND("department", ErrorMessage.DEPARTMENT_NOT_FOUND),

    POSITION_TITLE_EXIST("positionTitle", ErrorMessage.POSITION_TITLE_EXIST),
    POSITION_NOT_FOUND("position", ErrorMessage.POSITION_NOT_FOUND),

    EMPLOYEE_NOT_FOUND("employee", ErrorMessage.EMPLOYEE_NOT_FOUND);

    private String field;
    private String message;

    ErrorCode(String field, String message) {
        this.field = field;
        this.message = message;
    }

    ErrorCode(String message) {
        this.message = message;
    }
}
