package com.s2w.preassignment.attackmanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> serviceException(ApplicationException e) {
        ErrorResponse response = new ErrorResponse(e.getErrorType().name(), e.getMessage());

        return ResponseEntity.status(e.status())
                .body(response);
    }
}
