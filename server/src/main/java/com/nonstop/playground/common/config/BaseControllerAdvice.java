package com.nonstop.playground.common.config;

import com.nonstop.playground.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e) {
        log.error("Validation error is occurred");

        Map<String,String> errors = e.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toMap(
                        o -> ((FieldError) o).getField(),
                        o -> Optional.ofNullable(o.getDefaultMessage()).orElse(((FieldError) o).getField() + "'s validation error is occurred")));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(BaseException.class)
    public <T extends BaseException> ResponseEntity<BaseException> handleBaseExecption(T customException) {
        log.error(customException.getClassName() + "is occurred!", customException);

        return ResponseEntity.internalServerError().body(customException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleUnexpectedException(Exception exception) {
        log.error("Unexpected exception is occurred!", exception);

        return ResponseEntity.internalServerError().body(exception);
    }
}
