package com.nonstop.playground.common.config;

import com.nonstop.playground.common.exception.BaseException;
import lombok.Data;

@Data
public class ExceptionDTO {

    private final String errorCode;

    private final String message;

    public ExceptionDTO(Exception exception) {
        this.errorCode = "UNKNOWN";
        this.message = exception.getMessage();
    }

    public ExceptionDTO(BaseException baseException) {
        this.errorCode = baseException.getErrorCode();
        this.message = baseException.getMessage();
    }
}
