package com.elixrlbs.ChatApp.exceptionhandling;

import com.elixrlbs.ChatApp.response.FailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception Handler class for Controller
 */
@RestControllerAdvice
public class MessageExceptionHandler {

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<FailureResponse> handleMessageException(MessageException messageException) {
        List<String> errors = new ArrayList<>();
        errors.add(messageException.getMessage());
        return new ResponseEntity<>(new FailureResponse(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<FailureResponse> handleMessageNotFoundException(MessageNotFoundException messageNotFoundException) {
        List<String> errors = new ArrayList<>();
        errors.add(messageNotFoundException.getMessage());
        return new ResponseEntity<>(new FailureResponse(errors), HttpStatus.NOT_FOUND);
    }
}
