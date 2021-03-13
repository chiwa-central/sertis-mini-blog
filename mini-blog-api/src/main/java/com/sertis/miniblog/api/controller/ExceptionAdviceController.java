package com.sertis.miniblog.api.controller;

import com.sertis.miniblog.api.exception.AuthenticationException;
import com.sertis.miniblog.api.model.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceController {

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorResponse handleAuthenticationException(AuthenticationException ex) {
        return new ApiErrorResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), ex.getDeveloperMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorResponse handleUsernameNotFoundException(UsernameNotFoundException ex) {
        return new ApiErrorResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), null);
    }

}