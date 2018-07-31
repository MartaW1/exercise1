package com.martaw.exercise.service;

import com.martaw.exercise.model.exception.ServiceNotAvailableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ServiceNotAvailableException.class})
    protected ResponseEntity<Object> serviceNotAvailable(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "ServiceNotAvailable";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }
}