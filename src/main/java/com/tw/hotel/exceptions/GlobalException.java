package com.tw.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> handleNullPointer(NullPointerException ex) {
        ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), "Required user data is missing in the request.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleMissingData(MethodArgumentNotValidException ex) {
        ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), "Required user data is missing in the request");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingUser.class)
    public ResponseEntity<ErrorDetails> handleExistingUserError(ExistingUser ex) {
        ErrorDetails error = new ErrorDetails(HttpStatus.FORBIDDEN.value(), "User already exists, cannot register again");
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
}