package com.nonstop.playground.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 */
@Getter
public class BaseException extends RuntimeException{
    private final String className;

    private final String errorCode;

    @JsonIgnore
    private final HttpStatus httpStatus;

    public BaseException(String message, String className, String errorCode, HttpStatus httpStatus) {
        super(message);
        this.className = className;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public BaseException(String message, String className, String errorCode) {
        this(message, className, errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
