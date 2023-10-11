package com.desafios.user.exception;

import com.desafios.user.exception.types.UserNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorBastion extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFound.class)
    protected ResponseEntity<ErrorResponse> handleUserNotFound(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("User Not Found", exception.getMessage());
        log.info("User not found. Exception: {}", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
