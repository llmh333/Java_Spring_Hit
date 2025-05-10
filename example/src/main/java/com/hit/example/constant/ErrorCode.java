package com.hit.example.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public enum ErrorCode {

    BOOK_ALREADY_EXIST(HttpStatus.CONFLICT, ErrorMessage.BOOK_ALREADY_EXISTS),
    BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorMessage.BOOK_NOT_FOUND),
    BOOK_NAME_ALREADY_EXISTS(HttpStatus.CONFLICT, ErrorMessage.BOOK_NAME_ALREADY_EXISTS),

    AUTHOR_CONFLICT(HttpStatus.CONFLICT, ErrorMessage.AUTHOR_CONFLICT),
    AUTHOR_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorMessage.AUTHOR_NOT_FOUND),

    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorMessage.CATEGORY_NOT_FOUND);
    HttpStatus httpStatus;
    final String message;
}
