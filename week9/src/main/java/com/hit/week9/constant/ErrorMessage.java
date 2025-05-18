package com.hit.week9.constant;

public class ErrorMessage {

    public static class User {

        public static final String USERNAME_ALREADY_EXISTS = "exception.username.already.exists";
        public static final String USERNAME_ERROR_VALIDATION = "exception.username.validation";
        public static final String PASSWORD_ERROR_VALIDATION = "exception.password.validation";
        public static final String USER_NOT_FOUND_ERROR = "exception.user.notfound";
    }

    public static class Authentication {
        public static final String AUTHENTICATION_FAILED = "exception.authentication.failed";
    }
}
