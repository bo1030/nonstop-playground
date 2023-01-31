package com.nonstop.playground.common.exception;

import lombok.Getter;

/**
 *
 */
@Getter
public class BaseException extends RuntimeException{
    private final String className;

    private final String errorCode;

    public BaseException(String message, String className, String errorCode) {
        super(message);
        this.className = className;
        this.errorCode = errorCode;
    }
}
