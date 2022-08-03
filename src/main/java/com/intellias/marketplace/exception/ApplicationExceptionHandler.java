package com.intellias.marketplace.exception;

import com.intellias.marketplace.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleUserNotFoundException(UserNotFoundException e) {
        return new Error(e.getMessage());
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Error handleNotEnoughMoneyException(NotEnoughMoneyException e) {
        return new Error(e.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleProductNotFoundException(ProductNotFoundException e) {
        return new Error(e.getMessage());
    }

    @ExceptionHandler(UserValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleUserValidationException(UserNotFoundException e) {
        return new Error(e.getMessage());
    }




}
