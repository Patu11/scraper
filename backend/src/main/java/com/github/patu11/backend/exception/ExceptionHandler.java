package com.github.patu11.backend.exception;

import com.github.patu11.backend.model.common.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ErrorMessage> handleNoSuchElementException(NoSuchElementException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
