package com.example.boot.exception;

import com.example.boot.response.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity handleDataNotFoundException(DataNotFoundException ex, WebRequest request){
        return new ResponseEntity(new ResponseBody<>("404", ex.getMessage(),""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex, WebRequest request){
        return new ResponseEntity(new ResponseBody<>("404", ex.getMessage(),""), HttpStatus.BAD_REQUEST);
    }
}
