package com.desafios.accounts.exception;

import com.desafios.accounts.exception.types.AccountNotFoundException;
import com.desafios.accounts.exception.types.InsufficientFundException;
import com.desafios.accounts.exception.types.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorBastion {
    @ExceptionHandler({AccountNotFoundException.class, UserNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleUserNotFound(Exception exception) {
        String msg = exception instanceof UserNotFoundException ? "User Not Found" : "Account Not Found";
        ErrorResponse errorResponse = new ErrorResponse(msg, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundException.class)
    protected ResponseEntity<ErrorResponse> handleBadRequest(Exception exc) {
        ErrorResponse error = new ErrorResponse("Insufficient funds", exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
