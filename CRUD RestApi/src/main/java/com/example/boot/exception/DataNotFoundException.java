package com.example.boot.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DataNotFoundException extends RuntimeException{

    private String message;

    public DataNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
