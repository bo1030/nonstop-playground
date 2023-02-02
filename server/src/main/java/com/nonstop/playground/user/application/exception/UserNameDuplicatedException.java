package com.nonstop.playground.user.application.exception;

import com.nonstop.playground.common.exception.BaseException;
import org.springframework.http.HttpStatus;

public class UserNameDuplicatedException extends BaseException {

    public UserNameDuplicatedException(String className) {
        super("", className, "", HttpStatus.BAD_REQUEST);
    }
}
