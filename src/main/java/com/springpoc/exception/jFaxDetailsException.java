package com.springpoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
public class jFaxDetailsException extends Exception{

   public jFaxDetailsException() {
        super(String.format(" Something goes wrong. "));
    }



}
