package com.manager.website.handler.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final HttpStatus errorCode;

    public CustomException(String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
