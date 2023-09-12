package com.s2w.preassignment.attackmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {

    private final ErrorType errorType;

    public ApplicationException(ErrorType errorType) {
        this.errorType = errorType;
    }
    public HttpStatus status() {
        return errorType.getHttpStatus();
    }

    public String getMessage(){
        return errorType.getMessage();
    }
}
