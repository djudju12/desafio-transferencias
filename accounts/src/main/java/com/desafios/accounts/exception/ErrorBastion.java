package com.desafios.accounts.exception;

import com.desafios.accounts.exception.types.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorBastion {
    @ExceptionHandler(AccountNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleUserNotFound(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("User Not Found", exception.getMessage());
        log.info("Account not found. Exception: {}", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
