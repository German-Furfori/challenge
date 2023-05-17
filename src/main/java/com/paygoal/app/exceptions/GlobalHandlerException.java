package com.paygoal.app.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.paygoal.app.constants.ExceptionStrings.*;
import static com.paygoal.app.constants.HashMapStrings.ERROR_CODE;
import static com.paygoal.app.constants.HashMapStrings.ERROR_MESSAGE;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runTimeExceptionHandler() {

        Map<String, Object> responseException = new HashMap<>();

        responseException.put(ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseException.put(ERROR_MESSAGE, GLOBAL_ERROR);

        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, Object> responseException = new HashMap<>();
        Map<String, String> errorMessages = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessages.put(error.getField(), error.getDefaultMessage());
        });

        responseException.put(ERROR_CODE, HttpStatus.BAD_REQUEST.value());
        responseException.put(ERROR_MESSAGE, errorMessages);

        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableExceptionHandler() {

        Map<String, Object> responseException = new HashMap<>();

        responseException.put(ERROR_CODE, HttpStatus.BAD_REQUEST.value());
        responseException.put(ERROR_MESSAGE, JSON_PARSE_ERROR);

        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }

}