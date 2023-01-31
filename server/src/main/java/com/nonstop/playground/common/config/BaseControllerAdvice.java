package com.nonstop.playground.common.config;

import com.nonstop.playground.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(BaseException.class)
    public <T extends  BaseException> ResponseEntity<BaseException> handleBaseExecption(T customException) {
        log.error(customException.getClassName() + "is occurred!", customException);

        return ResponseEntity.internalServerError().body(customException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleUnexpectedException(Exception exception) {
        log.error("Unexpected exception is occurred!", exception);

        return ResponseEntity.internalServerError().body(exception);
    }
}
